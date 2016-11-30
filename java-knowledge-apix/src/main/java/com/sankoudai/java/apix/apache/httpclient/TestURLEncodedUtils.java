package com.sankoudai.java.apix.apache.httpclient;

import junit.framework.TestCase;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TestURLEncodedUtils extends TestCase {
    public void testParse() throws URISyntaxException {
        // simple query string
        String queryString = "a=1&b=2";
        List<NameValuePair> pairList = URLEncodedUtils.parse(queryString, StandardCharsets.UTF_8);
        printPairs(pairList);

        // querystring with duplicate parameters:
        System.out.println("\nduplicate parameters: ");
        queryString = "a=1&b=2&b=3";
        pairList = URLEncodedUtils.parse(queryString, StandardCharsets.UTF_8);
        printPairs(pairList);

        // encoded querystring
        System.out.println();
        System.out.println("encoded querystring");
        queryString = "a=1&click_time=%221468394815%22";
        pairList = URLEncodedUtils.parse(queryString, StandardCharsets.UTF_8);
        printPairs(pairList);

        // url
        System.out.println();
        System.out.println("url: ");
        String url = "http://baidu.com?a=1&b=2";
        pairList = URLEncodedUtils.parse(new URI(url), StandardCharsets.UTF_8.toString());
        printPairs(pairList);

    }

    public void testFormat(){
        List<NameValuePair> pairs = examplePairs();
        String queryString = URLEncodedUtils.format(pairs, StandardCharsets.UTF_8.toString());
        System.out.println(queryString);
    }

    private void printPairs(Collection<NameValuePair> pairs) {
        for (NameValuePair pair : pairs) {
            System.out.println(pair.getName() + "=" + pair.getValue());
        }
    }

    private List<NameValuePair> examplePairs(){
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("a", "1"));
        pairs.add(new BasicNameValuePair("b", "1"));
        pairs.add(new BasicNameValuePair("b", "2"));
        return pairs;
    }
}
