package com.infy.bokbe6.swing;

import com.infy.bokbe6.utils.SwingUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class AerofoilDetails {

    private  String item;
    public AerofoilDetails(){

    }

    public AerofoilDetails(String item){
        this.item=item;
    }

    public void createDetailDisplayScreen(){

        JFrame detailFrame = new JFrame();

        detailFrame.setContentPane(getInfoFrame());
        detailFrame.setSize(620,480);

        SwingUtil.setDimensions(detailFrame);
        detailFrame.setVisible(true);
        detailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
    JPanel getInfoFrame(){

        JPanel mainDetailPanel =new JPanel(new BorderLayout(5,5));

        JPanel detailsPanel = new JPanel(new GridLayout(0,1));

        JLabel nameOfAerofoil = new JLabel(item);

        detailsPanel.add(nameOfAerofoil);

        mainDetailPanel.add(detailsPanel, BorderLayout.CENTER);


        return mainDetailPanel;
    }
}
