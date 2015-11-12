package com.sankoudai.java.api.io;

import junit.framework.TestCase;

import java.io.StringWriter;

/**
 * @author : sankoudai
 * @version : created at 2015/11/6
 */
public class TestStringWriter extends TestCase {
    public void testCreate(){
        StringWriter writer = new StringWriter();
    }

    public void testWrite(){
        StringWriter writer = new StringWriter();
        writer.write('a');
        writer.write('b');
        System.out.printf("TestStringWriter[testWrite]: result = %s \n", writer.toString());
    }

    public void testAppend(){
        StringWriter writer = new StringWriter();
        writer.append("a");
        writer.append("b");
        System.out.printf("TestStringWriter[testAppend]: result = %s \n", writer.toString());
    }

}
