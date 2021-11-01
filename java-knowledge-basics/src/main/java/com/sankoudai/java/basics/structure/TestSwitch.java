package com.sankoudai.java.basics.structure;

import junit.framework.TestCase;

/**
 * @author xuliufeng
 */
public class TestSwitch extends TestCase {
    public void testNonbreak() {
        int i = 0;
        String dest = null;
        switch (i) {
            case 0:
            case 1:
                dest = "first";
                break;
            default:
                dest = "end";
        }

        assertEquals("first", dest);
    }
}
