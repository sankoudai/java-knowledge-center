package com.sankoudai.java.api.container.stream;

import junit.framework.TestCase;

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
    }

    public void testFlatMap(){
        List<List<Integer>> twoLevelCollection = Arrays.asList(Arrays.asList(0, 1, 2), Arrays.asList(2, 3, 4));
        List<Integer> flatCollection = twoLevelCollection.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.printf("flatCollection: %s \n", flatCollection);
    }
}
