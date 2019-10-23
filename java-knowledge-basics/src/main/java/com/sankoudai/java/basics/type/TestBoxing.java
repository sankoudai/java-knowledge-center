package com.sankoudai.java.basics.type;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author : sankoudai
 * @version : created at 2015/8/11
 */
public class TestBoxing extends TestCase {
    public void testWrap() {
        //将基本类型包装为对象
        Integer i1 = new Integer(1);
        Integer i2 = Integer.valueOf(2);
        Integer i3 = 3;
    }

    /*-- Integer --*/

    /**
     * 测试将16进制字符串转换为整数
     */
    public void testHex() {
        Integer i = Integer.parseInt("1f", 16);
        System.out.printf("testHex: 1f = %d", i);
    }

    /**
     * Integer的同一和相等
     */
    public void testEquals() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);

        Assert.assertTrue(i != j);
        Assert.assertTrue(i.equals(j));
    }
}
