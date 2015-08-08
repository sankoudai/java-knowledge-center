package com.sankoudai.java.knowledge.time;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class YearIntelligence {
    public static boolean isLeapYear(int year){
        return (year%4==0 && year%100!=0) || year%400==0;
    }
}
