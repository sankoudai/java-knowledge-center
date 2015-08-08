package com.sankoudai.java.basics.oop;

import junit.framework.TestCase;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestInnerClass extends TestCase{
    private interface TestType{
        void method();
    }

    public void testInnerClass(){
        TestType t = new TestType() {
            @Override
            public void method() {
                System.out.println("test method");
            }
        };

        t.method();
    }
}
