package com.infy.bokbe6.swing;

import com.infy.bokbe6.utils.SwingUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class DetailsScreen {

    private String item;

    DetailsScreen(String item) {
        this.item = item;
    }

    void createDetailDisplayScreen() {

        //setup parent frame
        JFrame detailFrame = new JFrame();
        //set the content pane into the frame
        detailFrame.setContentPane(setupDetailsPanel());
        detailFrame.setSize(620, 480);
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
        JLabel nameOfAerofoil = new JLabel(item);
        detailsPanel.add(nameOfAerofoil);
        mainDetailPanel.add(detailsPanel, BorderLayout.CENTER);

        return mainDetailPanel;
    }
}
