package com.sankoudai.java.api.io.stream.text;

import junit.framework.TestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * @author : sankoudai
 * @version : created at 2015/9/6
 */
public class TestReader extends TestCase {
    private Reader reader;

    @Override
    public void setUp() throws Exception {
        reader = new InputStreamReader(new FileInputStream("src/main/resources/io/fis.txt"), "utf-8");
    }

    @Override
    public void tearDown() throws Exception {
        reader.close();
    }

    /* debug this method */
    public void testRead() throws IOException {
        /* read char */
        char ch = (char) reader.read();
        System.out.printf("TestReader[testRead]: char=%s \n", ch);

        /* read char[] */
        char[] chars = new char[11];
        Integer numOfChars = reader.read(chars);
        System.out.printf("TestReader[testRead]: numOfChars=%s, chars=%s \n", numOfChars, Arrays.toString(chars));

        /* read into part of array */
        numOfChars = reader.read(chars, 0, 10);
        System.out.printf("TestReader[testRead]: numOfChars=%s, chars=%s \n", numOfChars, Arrays.toString(chars));
    }

}
