package com.sankoudai.java.api.url;

import junit.framework.TestCase;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by xuliufeng on 2015/12/14.
 */
public class TestURLEncoder extends TestCase {
    public void testEncode() throws UnsupportedEncodingException {
        String encodeResult = URLEncoder.encode("^", "utf-8");
        System.out.println(encodeResult);
    }
}
