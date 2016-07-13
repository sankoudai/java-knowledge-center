package com.sankoudai.java.api.encode;

import junit.framework.TestCase;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class TestMessageDigest extends TestCase {
    public void testDigest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("md5");

        byte[] bytes = "password".getBytes("utf8");
        digest.update(bytes);
        byte[] md5 = digest.digest();

        System.out.println();
        System.out.println(md5.length);
        System.out.println(toHex(md5));
    }


    private String toHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }
}
