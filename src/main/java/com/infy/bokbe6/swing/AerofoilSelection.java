package com.infy.bokbe6.swing;


import com.infy.bokbe6.SwingApplication;
import com.infy.bokbe6.utils.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class AerofoilSelection {


    JFrame aeroFrame;

    public void showAerofoilSelection() {

        aeroFrame = new JFrame("Select Aerofoil");

        aeroFrame.setContentPane(getPanel());
        aeroFrame.pack();
        SwingUtil.setDimensions(aeroFrame);
        aeroFrame.setVisible(true);
        aeroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    JPanel getPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout(3, 3));

        JPanel labels = new JPanel(new GridLayout(0, 1));

        JPanel fields = new JPanel(new GridLayout(0, 1));

        final String[] aerofoilNames = {"NACA116", "NACA670020", "NACA670110"};

        JLabel selectAerofoil = new JLabel("Select aerofoil");
        final JComboBox selectionBox = new JComboBox();

        for (int i = 0; i < aerofoilNames.length; i++) {
            selectionBox.addItem(aerofoilNames[i]);
        }

        labels.add(selectAerofoil);

        fields.add(selectionBox);

        JButton showButton = new JButton("Show");

        showButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                aeroFrame.dispose();
                aeroFrame.setVisible(false);
                String item = (String) selectionBox.getSelectedItem();
                AerofoilDetails aerofoilDetails=new AerofoilDetails(item);
                aerofoilDetails.createDetailDisplayScreen();


            }
        });




        mainPanel.add(labels, BorderLayout.WEST);
        mainPanel.add(fields, BorderLayout.CENTER);
        mainPanel.add(showButton, BorderLayout.SOUTH);

        return mainPanel;

    }
}
