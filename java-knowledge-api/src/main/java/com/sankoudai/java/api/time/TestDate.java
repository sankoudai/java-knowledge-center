package com.sankoudai.java.api.time;

import junit.framework.TestCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    /**
     * Date and Time Pattern 	        Result
     * "yyyy.MM.dd G 'at' HH:mm:ss z" 	2001.07.04 AD at 12:08:56 PDT
     * "EEE, MMM d, ''yy" 	            Wed, Jul 4, '01
     * "h:mm a" 	                    12:08 PM
     * "hh 'o''clock' a, zzzz" 	        12 o'clock PM, Pacific Daylight Time
     * "K:mm a, z" 	                    0:08 PM, PDT
     * "yyyyy.MMMMM.dd GGG hh:mm aaa" 	02001.July.04 AD 12:08 PM
     * "EEE, d MMM yyyy HH:mm:ss Z" 	Wed, 4 Jul 2001 12:08:56 -0700
     * "yyMMddHHmmssZ" 	                010704120856-0700
     * "yyyy-MM-dd'T'HH:mm:ss.SSSZ" 	2001-07-04T12:08:56.235-0700
     *
     * @throws ParseException
     */
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

        str = "26/Apr/2014 09:37:55 +0800";
        fmt = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss Z", Locale.US);
        date = fmt.parse(str);
        System.out.printf("testConversionWithString-from string: string=%s, fmtPattern=%s, date=%s \n", str, fmt.toPattern(), date);

        str = "2014-7-24 12:00:00.0123";
        fmt = new SimpleDateFormat("yyyy-M-d HH:mm:ss.SSS");
        date = fmt.parse(str);
        System.out.printf("testConversionWithString-from string: string=%s, fmtPattern=%s, date=%s \n", str, fmt.toPattern(), date);

        /*to string*/
        date = new Date();
        fmt = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
        str = fmt.format(date);
        System.out.printf("testConversionWithString-to string: date=%s, string=%s \n", date, str);

        System.out.println();
    }

    public void testTmp(){
        // 2016/05/10 19:18:29.000
        Date date = new Date(1467888137865L);
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(date));
    }

}
