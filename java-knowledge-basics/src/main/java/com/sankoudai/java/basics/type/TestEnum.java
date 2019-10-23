package com.sankoudai.java.basics.type;

import com.sankoudai.java.basics.entry.Color;
import junit.framework.TestCase;

/**
 * @author xuliufeng
 */
public class TestEnum extends TestCase {
    public void testEqual() {
        Color red = Color.Red;
        assert(red == Color.Red);
        assert(red.equals(Color.Red));
        assert(null != Color.Red);
    }
}
