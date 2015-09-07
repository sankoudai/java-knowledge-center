package com.sankoudai.java.api.container;

import junit.framework.TestCase;

import java.util.ResourceBundle;

/**
 * @author : sankoudai
 * @version : created at 2015/8/25
 */
public class TestResourceBundle extends TestCase {
    public void testGetBundle(){
        ResourceBundle bundle = ResourceBundle.getBundle("test");
        System.out.printf("TestResourceBundle[testGetBundle]: name=%s", bundle.getString("name"));
    }

    public void testBundleName(){
        ResourceBundle bundle = ResourceBundle.getBundle("test");
        String name = bundle.getBaseBundleName();
        System.out.println(name);
    }
}
