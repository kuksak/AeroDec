package com.infy.bokbe6.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class SwingUtil {

    public  static  void setDimensions(JFrame jFrame){

        Dimension dimension= Toolkit.getDefaultToolkit().getScreenSize();
        int x= (int) ((dimension.getWidth()-jFrame.getWidth())/2);
        int y= (int) ((dimension.getHeight()-jFrame.getHeight())/2);

        jFrame.setLocation(x,y);
    }
}
