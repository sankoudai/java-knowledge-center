package com.sankoudai.java.api.container.list;


import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author sankoudai
 */
public class TestListIterator extends TestCase {
    public void testAdd() {
        List<Integer> expectedInts = Arrays.asList(100, 0, 1, 2);
        List<Integer> ints = new LinkedList<Integer>(Arrays.asList(0, 1, 2));
        ListIterator<Integer> iter = ints.listIterator(0);
        iter.add(1000);
        iter.add(2000);
        while (iter.hasNext()) {
            iter.next();
        }
        iter.add(100);
        //        Assert.assertTrue(ints.equals(expectedInts));

        System.out.println(ints);
    }
}
