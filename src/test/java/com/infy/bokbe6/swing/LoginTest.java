package com.infy.bokbe6.swing;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class LoginTest {


    @Test
    public void testGetLoginPanel(){
        Login login = new Login();
        JPanel jpanel = login.getLoginPanel();
        Assert.assertNotNull(jpanel);
    }

}
