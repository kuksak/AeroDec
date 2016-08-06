package com.infy.bokbe6.swing;

import com.infy.bokbe6.utils.SwingUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class Login  {
    private JFrame loginScreen;

    public Login(){

    }

    /**
     * creates login screen
     */
    public void createLoginScreen(){

        loginScreen = new JFrame();
        JPanel loginPanel = getLoginPanel();

        loginScreen.setContentPane(loginPanel);
        /**
         *calling the method setLoginPanel which is returning a JPanel
         */
        loginScreen.pack();


        /**
         * calling the method setLocationDimension which is setting the loginScreen at the center
         */
        SwingUtil.setDimensions(loginScreen);
        loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        loginScreen.setVisible(true);

    }


    JPanel getLoginPanel() {
        JPanel loginPanel = new JPanel(new BorderLayout(3,3));
        loginPanel.setBorder(new EmptyBorder(5,5,5,5));


        JPanel labelPanel= new JPanel(new GridLayout(0,1));
        JLabel password = new JLabel("Password");
        labelPanel.add(new JLabel("Username"));
        labelPanel.add(password);

        JPanel textFieldPanel = new JPanel(new GridLayout(0,1));
        JTextField usernameText = new JTextField(10);
        JTextField passwordText = new JPasswordField(10);
        textFieldPanel.add(usernameText);
        textFieldPanel.add(passwordText);


        final JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
               loginScreen.dispose();
                loginScreen.setVisible(false);
                AerofoilSelection aerofoilSelection=new AerofoilSelection();
                aerofoilSelection.showAerofoilSelection();



            }
        });

        loginPanel.add(labelPanel , BorderLayout.WEST);
        loginPanel.add(textFieldPanel, BorderLayout.CENTER);
        loginPanel.add(loginButton , BorderLayout.SOUTH);
        return loginPanel;
    }
}
