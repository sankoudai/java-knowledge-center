package com.sankoudai.java.basics.oop;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestOverload extends TestCase{
    private class AClass{
        public int countParam(){
            return 0;
        }

        public int countParam(Object obj){
            return 1;
        }
    }

    public void testOverload(){
        AClass aClass = new AClass();
        Assert.assertEquals(0, aClass.countParam());
        Assert.assertEquals(1, aClass.countParam(null));
    }
}
