package com.infy.bokbe6.swing;

import com.infy.bokbe6.beans.AerofoilsEntity;
import com.infy.bokbe6.beans.CoordinatesEntity;
import com.infy.bokbe6.service.DetailService;
import com.infy.bokbe6.utils.SwingUtil;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class DetailsScreen {

    private List<AerofoilsEntity> aerofoilsEntityList;
    private List<CoordinatesEntity> coordinatesEntityList;
    private JFrame detailFrame;

    DetailsScreen(List<AerofoilsEntity> aerofoilsEntityList) {

        this.aerofoilsEntityList = aerofoilsEntityList;
    }

    void createDetailDisplayScreen() {

        //setup parent frame
        detailFrame = new JFrame();
        //set the content pane into the frame
        detailFrame.setContentPane(setupDetailsPanel());
        detailFrame.setSize(640, 480);
        //setup dimensions to align the window to center of screen
        SwingUtil.setDimensions(detailFrame);
        detailFrame.setVisible(true);
        detailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * setup details panel with information about aerofoil details and graphs
     *
     * @return JPanel
     */
    JPanel setupDetailsPanel() {

        JPanel mainDetailPanel = new JPanel(new BorderLayout(5, 5));
        JPanel detailsPanel = new JPanel(new GridLayout(0, 1));
        AerofoilsEntity aerofoilsEntity = aerofoilsEntityList.get(0);
        DetailService detailService = new DetailService();

        coordinatesEntityList = detailService.getCoordinates(aerofoilsEntity.getId());
        createGraph(detailsPanel);

        mainDetailPanel.add(detailsPanel, BorderLayout.CENTER);

        return mainDetailPanel;
    }


    private void createGraph(JPanel detailsPanel) {
        JPanel chartPanel = createChartPanel();
        detailsPanel.add(chartPanel);

    }

    private JPanel createChartPanel() {
        String chartTitle = "NACA Aerofoil Chart";
        String xAxisLabel = "X";
        String yAxisLabel = "Y";

        XYDataset xyDataset = createDataSet();
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, yAxisLabel, xAxisLabel, xyDataset, PlotOrientation.HORIZONTAL, true, false, false);
        return new ChartPanel(chart);
    }

    XYDataset createDataSet() {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        XYSeries xySeries = new XYSeries("FIRST SERIES", false, true);
        for (CoordinatesEntity coordinatesEntity : coordinatesEntityList) {
            xySeries.add(coordinatesEntity.getyCoordinate(), coordinatesEntity.getxCoordinate());
        }
        xySeriesCollection.addSeries(xySeries);
        return xySeriesCollection;
    }
}
