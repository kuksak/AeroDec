package com.infy.bokbe6.swing;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class LoginScreenTest {


    @Test
    public void testGetLoginPanel(){
        LoginScreen loginScreen = new LoginScreen();
        JPanel jpanel = loginScreen.setupLoginPanel();
        Assert.assertNotNull(jpanel);
    }

}
