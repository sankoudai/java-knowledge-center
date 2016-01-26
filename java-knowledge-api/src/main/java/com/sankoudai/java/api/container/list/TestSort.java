package com.sankoudai.java.api.container.list;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xuliufeng on 2016/1/10.
 */
public class TestSort extends TestCase {
    /**
     * 从小到大顺序
     */
    public void testOrder(){
        List<Integer> integers = Arrays.asList(4, 2, 3);
        Collections.sort(integers);
        System.out.println(integers);
    }
}
