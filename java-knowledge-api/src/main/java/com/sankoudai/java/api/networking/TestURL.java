package com.sankoudai.java.api.networking;

import junit.framework.TestCase;
import org.junit.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL extends TestCase {
    public void testParse() throws MalformedURLException {
        URL url = new URL("http://example.com:80/docs/books/index.html?name=networking#DOWNLOADING");
        Assert.assertEquals(url.getProtocol(), "http");
        Assert.assertEquals(url.getAuthority(), "example.com:80");
        Assert.assertEquals(url.getHost(), "example.com");
        Assert.assertEquals(url.getPort(), 80);
        Assert.assertEquals(url.getPath(), "/docs/books/index.html");
        Assert.assertEquals(url.getQuery(), "name=networking");
        Assert.assertEquals(url.getRef(), "DOWNLOADING");


    }
}
