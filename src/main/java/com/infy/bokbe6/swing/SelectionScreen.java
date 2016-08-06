package com.infy.bokbe6.swing;


import com.infy.bokbe6.beans.AerofoilsEntity;
import com.infy.bokbe6.service.SelectionService;
import com.infy.bokbe6.utils.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class SelectionScreen {

    private JFrame selectionFrame;

    void showAerofoilSelection() {

        selectionFrame = new JFrame("Select Aerofoil");
        selectionFrame.setContentPane(setupPanel());
        selectionFrame.pack();
        //set dimensions to align window to center of screen
        SwingUtil.setDimensions(selectionFrame);
        selectionFrame.setVisible(true);
        selectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * setup panel with a label and selection dropdown
     *
     * @return
     */
    JPanel setupPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout(3, 3));

        JPanel labels = new JPanel(new GridLayout(0, 1));
        JPanel fields = new JPanel(new GridLayout(0, 1));

        //fetch airfoil details from database
        SelectionService selectionService = new SelectionService();
        List<AerofoilsEntity> aerofoilsEntityList = selectionService.getAerofoilsEntityList();

        JLabel selectAerofoil = new JLabel("Select aerofoil");
        final JComboBox selectionBox = new JComboBox();

        for (AerofoilsEntity aerofoilsEntity : aerofoilsEntityList) {
            selectionBox.addItem("NACA " + aerofoilsEntity.getAerofoilName());
        }

        labels.add(selectAerofoil);
        fields.add(selectionBox);

        //setup show details button
        JButton showButton = new JButton("Show Aerofoil Details");
        showButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                selectionFrame.dispose();
                selectionFrame.setVisible(false);
                String item = (String) selectionBox.getSelectedItem();
                DetailsScreen detailsScreen = new DetailsScreen(item);
                detailsScreen.createDetailDisplayScreen();
            }
        });

        mainPanel.add(labels, BorderLayout.WEST);
        mainPanel.add(fields, BorderLayout.CENTER);
        mainPanel.add(showButton, BorderLayout.SOUTH);

        return mainPanel;
    }
}
