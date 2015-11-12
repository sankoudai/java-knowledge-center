package com.sankoudai.java.api.io.stream.binary;

import junit.framework.TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author : sankoudai
 * @version : created at 2015/9/6
 */
public class TestBinaryStream extends TestCase {
    /*-----------------File Stream------------------*/

    public void testRead() {
        FileInputStream in = null;

        /* 打开文件读取流 */
        try {
            in = new FileInputStream("TestBinaryStream.dat");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        /* 读取到int */
        try {
            int b = in.read();
            System.out.printf("Read a byte: b = %s\n", b);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*读取到byte[] */
        try {
            byte[] buf = new byte[5];
            int n = in.read(buf);
            System.out.printf("Read bytes: read num of bytes=%s, buf=%s\n", n, Arrays.toString(buf));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
