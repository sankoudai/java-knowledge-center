package com.sankoudai.java.api.time;

import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * java.time包中的类是不可变且线程安全的!
 * Instant——它代表的是时间戳
 * LocalDate——不包含具体时间的日期，比如2014-01-14。它可以用来存储生日，周年纪念日，入职日期等。
 * LocalTime——它代表的是不含日期的时间
 * LocalDateTime——它包含了日期及时间，不过还是没有偏移信息或者说时区。
 * ZonedDateTime——这是一个包含时区的完整的日期时间，偏移量是以UTC/格林威治时间为基准的。
 * Created by xuliufeng on 2015/11/24.
 */
public class TestJava8Time extends TestDate {
    /*---- LocalDate ----*/

    /**
     * 获取指定日期: yyyy-MM-dd
     */
    public void testDate() {
        /*today*/
        LocalDate today = LocalDate.now();
        System.out.printf("Today's local date: %s\n", today);

        /*specify day*/
        LocalDate date = LocalDate.of(2015, 1, 31);
        Assert.assertEquals("2015-01-31", date.toString());
    }

    /**
     * 获取日期分量
     */
    public void testDateElement() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("%s=%s-%s-%s\n", today.toString(), year, month, day);

        /* 周 */
        DayOfWeek week = today.getDayOfWeek();
        System.out.printf("week: %s\n", week);

        /*今天是本年第几天*/
        int days = today.getDayOfYear();
        System.out.printf("%s is %sth day of year\n", today, days);
    }

    public void testDateOperation() {
        LocalDate today = LocalDate.now();
        System.out.printf("now is %s \n", today);

        /* 一周之后的日期: +7d */
        LocalDate weekLater = today.plusWeeks(1);
        System.out.printf("A week later: %s \n", weekLater);

        /* 一月之后 */
        LocalDate monthLater = today.plusMonths(1);
        System.out.printf("A month later: %s \n", monthLater);

        /* 一年之后 */
        LocalDate yearLater = today.plusYears(1);
        System.out.printf("A year later: %s\n", yearLater);

        /* 求间隔: 使用Period */
        LocalDate later = today.plusMonths(1);
        Period period = Period.between(today, later);
        System.out.printf("today -> later = %s month \n", period.getMonths());

        /* 求间隔: 使用ChronoUnit */
        long days = ChronoUnit.DAYS.between(today, later);
        System.out.printf("today -> later = %s days \n", days);

        /* 年中的一天是星期几 */
        LocalDate middleYear = today.withDayOfYear(183);
        System.out.printf("Middle day of year: %s, %s \n", middleYear, middleYear.getDayOfWeek());

        /* 获取本月第一天 */
        LocalDate firstDayInMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.printf("first day of this month: %s\n", firstDayInMonth);

        /* 下个星期六 */
        LocalDate nextSaturday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        System.out.printf("next saturday : %s\n", nextSaturday);

        /* 到下个星期六还有多久 */
        period = today.until(nextSaturday);
        System.out.printf("There is %s days before next saturday", period.getDays());
    }

    public void testDateRelation() {
        LocalDate today = LocalDate.now();

        /* 先后 */
        LocalDate yesterday = today.minusDays(1);
        if (today.isBefore(yesterday)) {
            System.out.printf("It's impossible! Today is earlier than yesterday! \n");
        }

        /* 相等 */
        LocalDate date = LocalDate.of(2015, 11, 24);
        if (today.equals(date)) {
            System.out.printf("%s and %s are the same day !\n", today, date);
        } else {
            System.out.printf("%s and %s are not the same day !\n", today, date);
        }
    }

    /**
     * 日期属性
     */
    public void testDateProperty() {
        LocalDate date = LocalDate.of(2000, 11, 24);
        if (date.isLeapYear()) {
            System.out.printf("%s is leap year!\n", date);
        } else {
            System.out.printf("%s is not leap year!\n", date);
        }
    }

    /**
     * 各类型与LocalDate之间的转化
     */
    public void testDateConversion() {
        /* LocalDate-String: format */
        LocalDate date = LocalDate.of(2015, 9, 13);
        Assert.assertEquals("2015-09-13", date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        Assert.assertEquals("20150913", date.format(DateTimeFormatter.BASIC_ISO_DATE));
        Assert.assertEquals("2015-256", date.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        Assert.assertEquals("2015/09/13", date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        /* LocalDate-String: parse */
        Assert.assertEquals(date, LocalDate.parse("2015-09-13", DateTimeFormatter.ISO_LOCAL_DATE));

        /*LocalDate, LocalTime-LocalDateTime*/
        LocalDateTime dateTime = LocalDateTime.of(2015, 9, 13, 18, 30, 30);
        LocalTime time = LocalTime.of(18, 30, 30);
        Assert.assertEquals(date, LocalDate.from(dateTime));
        Assert.assertEquals(time, LocalTime.from(dateTime));
        Assert.assertEquals(dateTime, date.atTime(time));
    }

    /*---- LocalTime ----*/
    public void testTime() {
        /*获取当前时间(机器时间)*/
        LocalTime now = LocalTime.now();
        System.out.printf("local time now is %s \n", now);
    }

    /**
     * 时间操作
     */
    public void testTimeOperation() {
        /* 2小时以后 */
        LocalTime time = LocalTime.now();
        LocalTime later = time.plusHours(2);
        System.out.printf("Now is %s. Two hours later is %s \n", time, later);

        /* 7小时以后 */
        later = time.plusHours(7);
        System.out.printf("Now is %s. 7 hours later is %s \n", time, later);

    }


    /*---- LocalDateTime ----*/
    public void testConversion() {
        String time = "2015-11-24 11:24:00";
        LocalDateTime dateTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 另一时区的相同时间
     */
    public void testChangeZone() {
        LocalDateTime now = LocalDateTime.now();

        ZonedDateTime newYorkTime = ZonedDateTime.of(now, ZoneId.of("GMT-6"));
        System.out.printf("Local time: %s; GMT-6 time: %s \n", now.getHour(), newYorkTime.getHour());
    }


    /*---- MonthDay ----*/

    /**
     * 这个类由月日组合，不包含年信息
     * 可以用它来代表每年重复出现的一些日子
     */
    public void testMonthDay() {
        LocalDate birthday = LocalDate.of(2015, 12, 18);
        MonthDay monthDay = MonthDay.of(birthday.getMonthValue(), birthday.getDayOfMonth());

        MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
        if (currentMonthDay.equals(monthDay)) {
            System.out.printf("Happy birthday !\n");
        } else {
            System.out.printf("Sorry, today is not your birthday \n");
        }
    }

    /*---- Instant ----*/
    public void testInstant() {
        /* 一瞬间： 包含了时区信息 */
        Instant instant = Instant.now();
        System.out.printf("now is %s \n", instant.toString());

        /* 转化为Date */
        Date date = Date.from(instant);
        System.out.printf("now is %s \n", new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(date));

        /* date->instant */
        instant = date.toInstant();
        System.out.printf("now is %s \n", instant);
    }

    /*---- Clock ----*/
    public void testClock() {
        Clock clock = Clock.systemUTC();
        System.out.printf("clock : %s \n", clock);
    }
}
