package com.infy.bokbe6;

import org.junit.Assert;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class Test {

    @org.junit.Test
    public void testSomething(){
        int expected = 2;
        int actual = 1+1;
        Assert.assertEquals(expected,actual);
    }
}
