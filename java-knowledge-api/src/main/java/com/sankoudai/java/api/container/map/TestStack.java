package com.sankoudai.java.api.container.map;

import junit.framework.TestCase;

import java.util.Stack;

/**
 * @author : sankoudai
 * @version : created at 2015/8/11
 */
public class TestStack extends TestCase {
    public void testStack() {
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        while (!stack.isEmpty()) {
            System.out.printf("testStack: poped-elem = %s \n", stack.pop());
        }
    }
}
