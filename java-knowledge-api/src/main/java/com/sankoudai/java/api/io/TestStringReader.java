package com.sankoudai.java.api.io;

import junit.framework.TestCase;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

/**
 * @author : sankoudai
 * @version : created at 2015/8/6
 */
public class TestStringReader extends TestCase {
    public void testBuild() {
        StringReader reader = new StringReader("String Content");
    }

    public void testReadOne() throws IOException {
        StringReader reader = new StringReader("0123456");
        int ch = reader.read();
        System.out.printf("intValue=%d, charValue=%c", ch, (char) ch);
    }

    public void testReadMany() throws IOException {
        StringReader reader = new StringReader("0123456");
        char[] chs = new char[3];
        int len = reader.read(chs);
        System.out.printf("readMany: len=%d, chs=%s \n", len, Arrays.toString(chs));

        reader = new StringReader("0123456");
        chs = new char[8];
        len = reader.read(chs, 2, 4);
        System.out.printf("readMany: len=%d, chs=%s \n", len, Arrays.toString(chs));
    }

    public void testEOF() throws IOException {
        StringReader reader = new StringReader("0123456");
        char[] chs = new char[8];
        int len = reader.read(chs);
        System.out.printf("testEOF-firstRead: len=%d, chs=%s \n", len, Arrays.toString(chs));

        len = reader.read(chs);
        System.out.printf("readMany-EOFReached: len=%d, chs=%s \n", len, Arrays.toString(chs));
    }
}
