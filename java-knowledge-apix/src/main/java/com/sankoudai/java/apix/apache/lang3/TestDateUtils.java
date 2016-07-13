package com.sankoudai.java.apix.apache.lang3;

import junit.framework.TestCase;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateUtils extends TestCase {
    public void testAdd() throws Exception{
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2010-09-10 00:00:00");

        Date afterDate = DateUtils.addMinutes(date, 5);
        System.out.println(sdf.format(afterDate));
    }
}
