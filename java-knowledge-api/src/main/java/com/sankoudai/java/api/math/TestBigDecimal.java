package com.sankoudai.java.api.math;

import junit.framework.TestCase;

import java.math.BigDecimal;

/**
 * @author : sankoudai
 * @version : created at 2015/8/11
 */
public class TestBigDecimal extends TestCase {
    public void testBuild(){
        BigDecimal bd = new BigDecimal(3.1234);
        System.out.printf("testBuild: bigdecimal from double = %s \n", bd.toString());

        bd = new BigDecimal("3.1234");
        System.out.printf("testBuild: bigdecimal from String = %s \n", bd.toString());
        System.out.println();
    }

    public void testRound(){
        BigDecimal bigDecimal = new BigDecimal("3.856");
        //四舍五入取整
        System.out.println("testRound--round half up: (3.856)="
                + bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP));

        // 四舍五入保留两位小数
        System.out.println("testRound--round half up: (3.856)="
                + bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));


        //负数
        bigDecimal = new BigDecimal("-3.856");
        //四舍五入取整
        System.out.println("testRound--round half up: (-3.856)="
                + bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP));

        // 四舍五入保留两位小数
        System.out.println("testRound--round half up: (-3.856)="
                + bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println();
    }

    public void testAccuracy(){
        double val = Double.parseDouble("3.1234");
        BigDecimal bigDecimal = new BigDecimal("3.1234");

        bigDecimal = bigDecimal.multiply(bigDecimal).multiply(bigDecimal);
        double doubleValue = val * val * val;

        System.out.printf("testAccuracy-bigDecimal: 3.1234*3.1234*3.1234 = %s \n", bigDecimal);
        System.out.printf("testAccuracy-double: 3.1234*3.1234*3.1234 = %s \n", doubleValue);
        System.out.println();
    }
}
