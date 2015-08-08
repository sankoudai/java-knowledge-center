package com.sankoudai.java.basics.other;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Principle:
 *   for objects: == means same object, equals means look alike
 *   for primitives: == and equals  merge to one concept
 *
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestEquilty extends TestCase{
    public void testPrimitiveEquality(){
        int i = 3, j = 3;
        Assert.assertTrue(i == j);

        char ch1 = 'c', ch2 = 'c';
        Assert.assertTrue(ch1 == ch2);
    }

    public void testObjectEquality(){
        Integer i = 3, j = new Integer(3);
        Assert.assertTrue(i != j);
        Assert.assertTrue(i.equals(j));

    }

}
