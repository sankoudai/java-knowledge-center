package com.sankoudai.java.api.container.list;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : sankoudai
 * @version : created at 2015/8/11
 */
public class TestList extends TestCase {
    public void testGet() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 0, 1, 2);

        Assert.assertTrue(list.get(0) == 0);
    }

    public void testSubList() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 0, 1, 2, 3);

        /* aquire */
        List<Integer> subList = list.subList(2, list.size());
        System.out.printf("testSubList: list = %s, subList = %s \n", list.toString(), subList.toString());

        /* mutual affect */
        list.set(2, 9);
        System.out.printf("testSubList: list = %s, subList = %s \n", list.toString(), subList.toString());
        subList.set(0, 2);
        System.out.printf("testSubList: list = %s, subList = %s \n", list.toString(), subList.toString());
        subList.clear();
        System.out.printf("testSubList: list = %s, subList = %s", list.toString(), subList.toString());
    }

    public void testAdd() {
        List<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(1);
        list.add(3);
        System.out.printf("list=%s", list.toString());

        list.add(2, 2); // add(pos, elem)
        System.out.printf("list=%s", list.toString());
    }

    public void testSet() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 0, 1, 3);

        int originalElem = list.set(2, 2); //pos, val
        Assert.assertEquals(originalElem, 3);
    }

    public void testRemove() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 0, 1, 2);

        System.out.printf("test-remove: before remove list=%s \n", list.toString());
        list.remove(1);
        System.out.printf("test-remove: after remove list=%s \n", list.toString());
    }

    public void testMap(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3);

        List<String> a;
        String str = list.stream().map(n -> n.toString()).reduce((x, y) -> x+"|" +y).orElse("");

        System.out.println(str);
    }
}
