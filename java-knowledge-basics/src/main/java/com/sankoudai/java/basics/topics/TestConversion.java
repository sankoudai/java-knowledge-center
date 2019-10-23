package com.sankoudai.java.basics.topics;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestConversion extends TestCase{

    private interface Shape {}

    private class ShapeImpl implements Shape {}

    private interface Circle extends Shape {}

    private class CircleIml implements Circle {}

    /** Up conversion is automatically supported */
    public void testUpConversion(){
        Circle circle = new CircleIml();
        Shape shape = circle;
    }

    public void testDownConversion(){
        /* Down conversion succeeds if object is instance of subclass */
        Shape shape = new CircleIml();
        Circle circle = (Circle) shape;

        /* Down conversion fails if object isn't instance of subclass*/
        shape = new ShapeImpl();
        try{
            circle = (Circle) shape;
            Assert.assertTrue(false);
        }catch (Exception e){
            System.out.println("You ought to be here");
        }

        HashMap<String, Object> hm = new HashMap<>();
        Object obj = hm;
        Map<String, Object> m = (Map<String, Object>) obj;
    }
}
