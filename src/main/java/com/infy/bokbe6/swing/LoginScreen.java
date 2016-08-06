package com.infy.bokbe6.swing;

import com.infy.bokbe6.service.LoginService;
import com.infy.bokbe6.utils.SwingUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class LoginScreen {
    private JFrame loginScreen;


    /**
     * sets up screen for login details and starts it
     */
    public void startLoginScreen() {

        loginScreen = new JFrame();
        //setup login panel and add to the parent fram
        JPanel loginPanel = setupLoginPanel();
        //set this login panel to the login screen
        loginScreen.setContentPane(loginPanel);
        loginScreen.pack();

        //setup dimensions to the parent frame so that it aligns to the center of screen
        SwingUtil.setDimensions(loginScreen);
        loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //mark screen as visible
        loginScreen.setVisible(true);
    }

    /**
     * setup login panel with all the labels and fields
     *
     * @return JPanel
     */
    JPanel setupLoginPanel() {
        //set a bordered layout for the root panel
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


        final JButton loginButton = new JButton("LoginScreen");
        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                //perform login operation

                LoginService loginService = new LoginService();
                if (loginService.login(usernameText.getText(), passwordText.getText())) {
                    //decide whether to move to next screen of remain in the same one
                    loginScreen.dispose();
                    loginScreen.setVisible(false);
                    SelectionScreen selectionScreen = new SelectionScreen();
                    selectionScreen.showAerofoilSelection();
                } else {
                    JOptionPane.showMessageDialog(loginScreen, "invalid Credentials. Please try again!", "login Failed", JOptionPane.ERROR_MESSAGE);
                }



            }
        });

        loginPanel.add(labelPanel , BorderLayout.WEST);
        loginPanel.add(textFieldPanel, BorderLayout.CENTER);
        loginPanel.add(loginButton , BorderLayout.SOUTH);
        return loginPanel;
    }
}
