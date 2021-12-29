package com.sankoudai.java.apix.apache.lang3;

import junit.framework.TestCase;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author xuliufeng
 */
public class TestNumberUtils extends TestCase {
    public void testIsNumber() {
        assert NumberUtils.isNumber("111");
        assert NumberUtils.isNumber("1.11");
        assert NumberUtils.isNumber("1e-11");

        assert !NumberUtils.isNumber("1b-11");
        assert !NumberUtils.isNumber("1,111");
    }
}
