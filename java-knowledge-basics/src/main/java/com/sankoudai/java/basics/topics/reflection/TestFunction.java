package com.sankoudai.java.basics.topics.reflection;

import junit.framework.TestCase;

import java.util.function.Function;

public class TestFunction extends TestCase{
    public void testConstruct() {
        Function<String, Long> f = Long::valueOf;
        Long val = f.apply("3");
        System.out.println(val);

        Function<Object, Object> id = Function.identity();
        System.out.println(id.apply("3"));
    }
}
