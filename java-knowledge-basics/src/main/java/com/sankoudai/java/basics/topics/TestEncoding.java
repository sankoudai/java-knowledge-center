package com.sankoudai.java.basics.topics;

import junit.framework.TestCase;

import java.io.UnsupportedEncodingException;

/**
 * @author : sankoudai
 * @version : created at 2016/4/11
 */
public class TestEncoding extends TestCase {
    public void testUnicode() throws UnsupportedEncodingException {
        //char 字符， 本质上是一个数字
        int i = 0;


        //java内部对字符的编码采用 utf-16BE
        System.out.println("A:  utf-16be=" + intValueByUtf16BE('A') + "  intValue=" + (i = 'A') + " bits="
                        + Integer.toBinaryString('A'));
        System.out.println("B:  utf-16be=" + intValueByUtf16BE('B') + " intValue=" + (i = 'B') + " bits="
                        + Integer.toBinaryString('B'));
        System.out.println("C:  utf-16be=" + intValueByUtf16BE('C') + " intValue=" + (i = 'C') + " bits="
                        + Integer.toBinaryString('C'));
        System.out.println("中:  utf-16be=" + intValueByUtf16BE('中') + " intValue=" + (i = '中') + " bits="
                        + Integer.toBinaryString('中'));
        System.out.println("国:  utf-16be=" + intValueByUtf16BE('国') + " intValue=" + (i = '国') + " bits="
                        + Integer.toBinaryString('国'));
    }

    public void testUtf8() throws UnsupportedEncodingException {
        System.out.println("中: innerBits=" + Integer.toBinaryString('中') + "  utf8Bits=" + getBits("中".getBytes("utf-8")));
    }


    private int intValueByUtf16BE(char ch) throws UnsupportedEncodingException {
        String s = "" + ch;
        byte[] utf16 = s.getBytes("UTF-16BE");

        String bits = "";
        for (byte b : utf16) {
            bits += getBits(b);
        }

        return Integer.valueOf(bits, 2);
    }


    private String getBits(byte[] bytes) {
        String bits = "";
        for( byte b: bytes){
            bits += getBits(b) + " ";
        }

        return bits;
    }

    public String getBits(byte b) {
        String bits = Integer.toBinaryString(b & 0xff);//b有可能为负数, 股获取

        //padding leading zeroes
        int paddingLen = 8 - bits.length();
        for (int i = 0; i < paddingLen; i++) {
            bits = '0' + bits;
        }

        return bits;
    }
}
