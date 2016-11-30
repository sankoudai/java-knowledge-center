package com.sankoudai.java.api.encode;

import junit.framework.TestCase;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class TestURLEncoder extends TestCase {
    public void testEncode() throws UnsupportedEncodingException {
        String encodeResult = URLEncoder.encode("^", "utf-8");
        System.out.println(encodeResult);
    }

    public void testDecode() throws UnsupportedEncodingException {
        String txt = "722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2d0fc%26logId%3Dd74fd722-f7dc-4909-9fe6-103f15f2";
        System.out.println(URLDecoder.decode(URLDecoder.decode(txt, "utf-8"), "utf-8"));
        System.out.println(URLDecoder.decode(txt, "utf-8"));
    }
}
