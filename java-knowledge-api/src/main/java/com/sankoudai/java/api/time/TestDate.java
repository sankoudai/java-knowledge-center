package com.sankoudai.java.api.time;

import junit.framework.TestCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : sankoudai
 * @version : created at 2015/8/11
 */
public class TestDate extends TestCase {
    public void testBuild() {
        Date now = new Date();

        long millis = 0L;
        Date epoch = new Date(millis);
    }

    public void testGetTime() {
        Date now = new Date();
        long mills = now.getTime();

        System.out.printf("testGetTime: time = %s, millis = %d \n", now, mills);
        System.out.println();
    }

    public void testSetTime() {
        Date date = new Date();

        System.out.printf("testSetTime (before setTime): date = %s \n", date);
        long millis = date.getTime() - 24 * 3600 * 1000L;
        date.setTime(millis);
        System.out.printf("testSetTime (after setTime): date = %s \n", date);
    }

    public void testConversionWithString() throws ParseException {
        /*from string*/
        String str = "2014-7-24 12:00:00";
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
        Date date = fmt.parse(str);
        System.out.printf("testConversionWithString-from string: string=%s, fmtPattern=%s, date=%s \n", str, fmt.toPattern(), date);

        str = "19881016";
        fmt = new SimpleDateFormat("yyyyMMdd");
        date = fmt.parse(str);
        System.out.printf("testConversionWithString-from string: string=%s, fmtPattern=%s, date=%s \n", str, fmt.toPattern(), date);

        /*to string*/
        date = new Date();
        fmt = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
        str = fmt.format(date);
        System.out.printf("testConversionWithString-to string: date=%s, string=%s \n", date, str);

        System.out.println();
    }
}
