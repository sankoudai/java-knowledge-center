package com.sankoudai.java.api.container;

import org.junit.Assert;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * @author : sankoudai
 * @version : created at 2015/8/8
 */
public class TestArrays extends TestCase {
    public void testAsList() {
        String[] keys = {"a", "b"};
        List<String> keyList = Arrays.asList(keys);

        assertEquals(keyList.get(0), "a");
        assertEquals(keyList.get(1), "b");
    }

    public void testFill() {
        int[] ints = new int[5];
        Arrays.fill(ints, 1);
        System.out.printf("ints=%s \n", Arrays.toString(ints));
    }

    /**
     * Arrays.copyOf(arr, newLength): expand arr to size of newLength
     */
    public void testCopyOf() {
        int[] ints = {0, 1};

        int newLength = 3;
        int[] newInts = Arrays.copyOf(ints, newLength);
        Assert.assertEquals(newInts.length, newLength);
        Assert.assertEquals(ints[0], newInts[0]);
        Assert.assertEquals(ints[1], newInts[1]);
        Assert.assertEquals(0, newInts[2]);
    }

}
