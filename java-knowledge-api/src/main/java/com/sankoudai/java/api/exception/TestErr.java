package com.sankoudai.java.api.exception;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class TestErr extends TestCase {
    private class Foo {

    }

    /**
     * 测试堆内存溢出
     */
    public void testHeapMemory() {
        List<Foo> list = new ArrayList<Foo>();
        for (; ; ) {
            list.add(new Foo());
        }
    }

    /**
     * 测试栈内存溢出
     */
    public void testStackMemory() {
        int i = 5;
        testStackMemory();
    }
}
