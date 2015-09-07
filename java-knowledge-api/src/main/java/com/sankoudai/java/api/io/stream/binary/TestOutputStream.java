package com.sankoudai.java.api.io.stream.binary;

import junit.framework.TestCase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author : sankoudai
 * @version : created at 2015/9/6
 */
public class TestOutputStream extends TestCase{
    private OutputStream out;

    @Override
    public void setUp() throws Exception {
        out = new FileOutputStream("src/main/resources/io/io.bin");
    }

    @Override
    public void tearDown() throws Exception {
        out.close();
    }

    public void testWrite() throws IOException {
        /* write byte */
        int bin = '0';
        out.write(bin);

        /* write byte array */
        byte[] bytes = new byte[]{'0', '1'};
        out.write(bytes);

        /* write part of array */
        bytes = new byte[]{'0', '1', '2', '3', '4'};
        int offset = 2;
        int len = 2;
        out.write(bytes, offset, len);
    }

    public void testFileOutputStream() throws IOException {
        /* 截取方式输出流 */
        OutputStream fos = new FileOutputStream("src/main/resources/io/fos.bin");
        fos.write(new byte[]{'0', '1'});
        fos.close();

        /* 追加方式输出流 */
        fos = new FileOutputStream("src/main/resources/io/fos.bin", true);
        fos.write(new byte[]{'2', '3'});
        fos.close();
    }
}
