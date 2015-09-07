package com.sankoudai.java.basics.topics;

import org.junit.Assert;
import junit.framework.TestCase;

/**
 * @author : sankoudai
 * @version : created at 2015/8/16
 */
public class TestEnum extends TestCase {
    private static enum EnumExample {
        One(1), Two(2), Three(3);

        private Integer attr;

        EnumExample(Integer attr) {
            this.attr = attr;
        }

        public Integer intValue() {
            return this.attr;
        }
    }

    public void testElem() {
        EnumExample enumExample = EnumExample.One;
        Assert.assertTrue(EnumExample.One == enumExample);
        Assert.assertTrue(EnumExample.One != EnumExample.Two);
    }

    public void testMethod() {
        EnumExample enumExample = EnumExample.One;
        Assert.assertTrue(enumExample.intValue() == 1);
    }

    public void testEnumeration(){
        for(EnumExample enumExample : EnumExample.values()){
            System.out.printf("testEnumeration: enum-name = %s, enum-inValue=%s \n", enumExample.name(), enumExample.intValue());
        }
    }

    public void testSwitch(){
        EnumExample enumExample = null;
        try{
            switch (enumExample){
                case One:
                    System.out.printf("testSwitch: one\n");
                    return;
                case Two:
                    System.out.printf("testSwitch: two\n");
                    return;
            }
            Assert.assertTrue(false);
        }catch (NullPointerException e){
            System.out.printf("You should be here");
        }
    }
}
