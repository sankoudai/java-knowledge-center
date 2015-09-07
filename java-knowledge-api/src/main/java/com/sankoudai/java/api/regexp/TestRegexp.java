package com.sankoudai.java.api.regexp;

import junit.framework.TestCase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : sankoudai
 * @version : created at 2015/8/16
 */
public class TestRegexp extends TestCase {
    public void testGroup(){
        String str = "4/7/15";

        //pattern matcher分组
        Pattern pattern = Pattern.compile("(.*/)(\\d+)");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            System.out.println(matcher.group(0)); //整个字符串
            System.out.println(matcher.group(1)); // 对应 (.*/)
            System.out.println(matcher.group(2)); // 对应(\\d+)

            System.out.println(matcher.group(1) + "20" + matcher.group(2));
        }
    }
}
