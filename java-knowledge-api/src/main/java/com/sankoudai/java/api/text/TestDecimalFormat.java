package com.sankoudai.java.api.text;

import junit.framework.TestCase;
import org.junit.Assert;

import java.text.DecimalFormat;

public class TestDecimalFormat extends TestCase {
    public void test() {
        DecimalFormat format = new DecimalFormat("#0.00");
        Assert.assertEquals("3456.12", format.format(3456.123));
        Assert.assertEquals("4.12", format.format(4.123));
    }
}
