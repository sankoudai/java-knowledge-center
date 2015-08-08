package com.sankoudai.java.basics.oop;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestExtends extends TestCase{
    private class Parent{
        public String getName(){
            return "parent";
        }
    }

    private class Child extends Parent{
        @Override
        public String getName() {
            return "child";
        }
    }

    public void testMethodOverride(){
        Child child = new Child();
        Assert.assertEquals("child", child.getName());
    }
}
