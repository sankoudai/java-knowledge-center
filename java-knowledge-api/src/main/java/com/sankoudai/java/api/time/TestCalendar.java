package com.sankoudai.java.api.time;

import junit.framework.TestCase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author : sankoudai
 * @version : created at 2015/8/13
 */
public class TestCalendar extends TestCase {
    public void testBuild() {
        /*default to now*/
        Calendar calendar = Calendar.getInstance();
        /*default to now*/
        calendar = new GregorianCalendar();

        /*designate time*/
        int year = 2012;
        int month = Calendar.JULY;
        int day = 25;
        calendar = new GregorianCalendar(year, month, day);
    }

    public void testFields() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; //月份从0开始, 其余正常
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);

        System.out.printf("testComponents: year=%s \n", year);
        System.out.printf("testComponents: month=%s \n", month);
        System.out.printf("testComponents: dayOfMonth=%s \n", dayOfMonth);
        System.out.printf("testComponents: dayOfWeek=%s \n", dayOfWeek);
        System.out.printf("testComponents: dayOfYear=%s \n", dayOfYear);
        System.out.printf("testComponents: hourOfDay=%s \n", hourOfDay);
    }

    public void testConversionWithDate() {
        /* to date */
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.printf("testConversionWithDate--to date: cal =%s \n", cal.getTimeInMillis());
        System.out.printf("testConversionWithDate--to date: date = %s\n", date);
        System.out.println();

        /* from date */
        date = new Date();
        cal.setTimeInMillis(date.getTime());
        System.out.printf("testConversionWithDate--from date: date = %s\n", date);
        System.out.printf("testConversionWithDate--from date: cal =%s \n", cal.getTimeInMillis());
    }

    // TODO: summarize
    public void testYearProperties() {
        Calendar cal = Calendar.getInstance();
    }

    public void testMonthProperties() {
        Calendar cal = new GregorianCalendar(2015, Calendar.FEBRUARY, 1);
        int actualMaximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int maximum = cal.getMaximum(Calendar.DAY_OF_MONTH);
        int leastMaximum = cal.getLeastMaximum(Calendar.DAY_OF_MONTH);

        System.out.printf("testMonthProperties: actualMaximum=%s \n", actualMaximum);
        System.out.printf("testMonthProperties: maximum=%s \n", maximum);
        System.out.printf("testMonthProperties: leastMaximum=%s \n", leastMaximum);
    }

    // TODO: summarize
    public void testWeekProperties() {

    }

    public void testDayProperties() {
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        if (dayOfWeek == Calendar.THURSDAY) {
            System.out.printf("testDayProperties: thursday \n");
        }
    }

    /**
     * 时间增加机制：
     * 增加月或者年时，  首先会平移相应分量； 如果日期分量超出了范围， 则取最后一天
     */
    public void testAdd() {
        String original = null;
        String afterAdd = null;

        /* operation in normal range */
        Calendar cal = Calendar.getInstance();
        original = getString(cal);
        cal.add(Calendar.YEAR, 1);
        afterAdd = getString(cal);
        System.out.printf("testAdd: %s + 1year = %s \n", original, afterAdd);
        System.out.println();

        cal = Calendar.getInstance();
        original = getString(cal);
        cal.add(Calendar.MONTH, -1);
        afterAdd = getString(cal);
        System.out.printf("testAdd: %s -1month = %s \n", original, afterAdd);
        System.out.println();

        cal = Calendar.getInstance();
        original = getString(cal);
        cal.add(Calendar.WEEK_OF_YEAR, -1);
        afterAdd = getString(cal);
        System.out.printf("testAdd: %s -1week = %s \n", original, afterAdd);
        System.out.println();

        cal = Calendar.getInstance();
        original = getString(cal);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        afterAdd = getString(cal);
        System.out.printf("testAdd: %s - 1day = %s \n", original, afterAdd);
        System.out.println();

        /* operation out of range */
        System.out.println("------------singular case---------------");

        //2000.02.29 + 1年 ====> 2001.02.28
        cal = new GregorianCalendar(2000, Calendar.FEBRUARY, 29); //2000.02.29
        original = getString(cal);
        cal.add(Calendar.YEAR, 1);
        afterAdd = getString(cal);
        System.out.printf("testAdd: %s + 1year = %s \n", original, afterAdd);
        System.out.println();

        //2000.02.29 - 1年 ====> 1999.02.28
        cal = new GregorianCalendar(2000, Calendar.FEBRUARY, 29); //2000.02.29
        original = getString(cal);
        cal.add(Calendar.YEAR, 1);
        afterAdd = getString(cal);
        System.out.printf("testAdd: %s - 1year = %s \n", original, afterAdd);
        System.out.println();

        //2000.03.31 + 1月 ===> 2000.04.30
        cal = new GregorianCalendar(2000, Calendar.MARCH, 31);
        original = getString(cal);
        cal.add(Calendar.MONTH, 1);
        afterAdd = getString(cal);
        System.out.printf("testAdd: %s + 1month = %s \n", original, afterAdd);
        System.out.println();

        //2000.04.30 + 1月 ===> 2000.05.30
        cal = new GregorianCalendar(2000, Calendar.APRIL, 30);
        original = getString(cal);
        cal.add(Calendar.MONTH, 1);
        afterAdd = getString(cal);
        System.out.printf("testAdd: %s + 1month = %s \n", original, afterAdd);
        System.out.println();

        //2000.01.03 - 5天  ===> 2000.05.30
        cal = new GregorianCalendar(2000, Calendar.JANUARY, 3);
        original = getString(cal);
        cal.add(Calendar.DATE, -5);
        afterAdd = getString(cal);
        System.out.printf("testAdd: %s - 5day = %s \n", original, afterAdd);
        System.out.println();


    }

    private String getString(Calendar cal) {
        if (cal == null) {
            return null;
        }

        SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return fmt.format(cal.getTime());
    }
}
