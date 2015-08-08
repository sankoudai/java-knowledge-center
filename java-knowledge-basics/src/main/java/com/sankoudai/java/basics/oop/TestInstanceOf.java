package com.sankoudai.java.basics.oop;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestInstanceOf extends TestCase{
    private class Parent{}
    private class Child extends Parent{}
    
    public void testInstanceOf (){
        Child child = new Child();
        Assert.assertTrue(child instanceof Child);
        Assert.assertTrue(child instanceof Parent);
    }
}
