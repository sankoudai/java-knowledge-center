package com.sankoudai.java.api.container.stream;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : sankoudai
 * @version : created at 2015/9/24
 */
public class TestStream extends TestCase {
    public void testStream() {
        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        System.out.println("sum is:" + nums.stream().filter(num -> num != null).
                        distinct().mapToInt(num -> num * 2).
                        peek(System.out::println).skip(2).limit(4).sum());

        //使用stream进行copy
        nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        List<Integer> copy = nums.stream().collect(Collectors.toList());
        copy.add(11);
        System.out.println(nums);
        System.out.println(copy);
    }

    public void test(){
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);

        List list = map.values().stream().collect(Collectors.toList());
        System.out.println(list);
    }

    public void testFilter(){
        List<Integer> ints = Arrays.asList(1, 2, 3);
        ints.stream().filter(integer -> integer%2==0).forEach(System.out::println);

        //空的list
        List<Integer> filteredInts = ints.stream().filter(i -> i>3).collect(Collectors.toList());
        Assert.assertTrue(filteredInts.size() == 0);
    }

    public void testFlatMap(){
        List<List<Integer>> twoLevelCollection = Arrays.asList(Arrays.asList(0, 1, 2), Arrays.asList(2, 3, 4));
        List<Integer> flatCollection = twoLevelCollection.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.printf("flatCollection: %s \n", flatCollection);
    }

    public void testAnyMatch(){
        List<Integer> ints = Arrays.asList(1, 2, 3);
        boolean b = ints.stream().anyMatch(integer -> integer %2 ==0);
        Assert.assertTrue(b);

        ints = new ArrayList<>();
        b = ints.stream().anyMatch(integer -> integer %2 ==0);
        Assert.assertFalse(b);
    }
}
