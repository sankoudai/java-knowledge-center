package com.sankoudai.java.basics.type;

import org.junit.Assert;
import junit.framework.TestCase;

/**
 * @author : sankoudai
 * @version : created at 2015/8/5
 */
public class TestInt extends TestCase {
    public void testValue() {
        int i = 10;
        Assert.assertEquals(10, i);

        int hexInt = 0xff;
        Assert.assertEquals(16 * 15 + 15, hexInt);

        int binInt = 0b11;
        Assert.assertEquals(2 * 1 + 1, binInt);
    }

    public void testMaxValue() {
        int maxInt = Integer.MAX_VALUE;
        System.out.printf("maxInt = %d, about 2billion \n", maxInt);
    }

    public void testOverflow() {
        int maxInt = Integer.MAX_VALUE;
        System.out.printf(" maxInt + 1 = %d \n", maxInt + 1);
        System.out.println("So int set forms a ring!!");
    }

    public void testDivide() {
        Assert.assertEquals(10%3, 1);
        Assert.assertEquals(10/3, 3);

    }
}
