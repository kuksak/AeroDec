package com.infy.bokbe6;

import com.infy.bokbe6.swing.LoginScreen;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class SwingApplication {
    /**
     * Application Runner
     *
     * @param args
     */
    public static void main(String[] args) {
        //start login screen by default
        LoginScreen loginScreenScreen = new LoginScreen();
        loginScreenScreen.startLoginScreen();
    }
}
