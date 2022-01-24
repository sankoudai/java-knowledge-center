package com.sankoudai.java.basics.topics;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author : sankoudai
 * @version : created at 2015/8/11
 */
public class TestParameter extends TestCase {
    public void testVarargs(){
        varargsMethod("jim", "Lilei");

        varargsMethod(null, "hi");
    }

    private void varargsMethod(Object ... params){
        System.out.println(params.getClass());
        System.out.println(params instanceof Object[]);
        System.out.println(Arrays.toString(params));
    }
}
