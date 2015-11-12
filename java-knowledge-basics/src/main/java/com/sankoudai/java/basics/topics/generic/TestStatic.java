package com.sankoudai.java.basics.topics.generic;

import junit.framework.TestCase;

/**
 * @author : sankoudai
 * @version : created at 2015/9/10
 */
public class TestStatic extends TestCase {
    public void test(){
        Object obj = "string";
        String string = genericReturnType(String.class, obj);
        System.out.printf("After convertion: %s\n", string);
    }

    private static <T> T genericReturnType(Class<T> cls, Object obj){
        return (T) obj;
    }
}
