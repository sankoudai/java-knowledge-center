package com.sankoudai.java.basics.topics.reflection;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author : sankoudai
 * @version : created at 2016/2/14
 */
public class TestType extends TestCase {

    /**
     * 判断值的类型
     */
    public void testType() {
        Integer i = 0;
        Assert.assertTrue(i instanceof Integer);

        Class<Integer> cls = Integer.class;
        Assert.assertTrue(cls.isInstance(i));
    }

    public void testClassFor() {
        try {
            Class cls =  Class.forName("com.sankoudai.java.basics.topics.reflection.RClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
