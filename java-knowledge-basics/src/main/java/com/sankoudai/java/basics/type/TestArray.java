package com.sankoudai.java.basics.type;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestArray extends TestCase {
    public void testBuild(){
        // 初始化为0
        int[] a = new int[4];

        int[] b = {0, 1, 2, 3};

        int[] c = new int[]{0, 1, 2, 3};
    }

    public void testLength(){
        int[] a = new int[4];
        Assert.assertEquals(4, a.length);
    }

    public void testDimension(){
        int[][] a = new int[3][];
        a[0] = new int[2];
        a[1] = new int[6];
        a[2] = new int[8];
        a[0][0] = 0;
        Assert.assertEquals(3, a.length);

        a = new int[3][4];
        a[0][0] = 0;
    }

    public void testEqual(){
        int[] b = {0, 1, 2, 3};
        int[] c = new int[]{0, 1, 2, 3};

        Assert.assertTrue(b != c);
        Assert.assertTrue(! b.equals(c));
    }

    public void testForeach(){
        String[] strings = {"one", "two", "three"};
        for (String i : strings){
            System.out.printf("foreach - item = %s  \n", i);
        }
    }

}
