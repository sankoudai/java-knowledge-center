package com.sankoudai.java.api.exception;

import junit.framework.TestCase;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TestException extends TestCase {

    /**
     * unchecked: IndexOutofBoundsException
     */
    public void test4() {
        List<String> list = new ArrayList<String>();
        list.add("tom");
        list.get(-1); //ArrayIndexOutOfBoundsException
        list.get(2);    //IndexOutOfBoundsException
    }


    /**
     * unchecked: ArithmeticException
     */
    public void test3() {
        int i = 1 / 0;
        System.out.println(i);
    }

    /**
     * unchecked: ClassCastException
     */
    public void test2() {
        Number b = new Double(1.2);
        Integer i = (Integer) b;
        System.out.println(i);
    }

    /**
     * uncheck:ArrayIndexOutofBoundsException
     */
    public void test1() {
        int[] arr = new int[9];

        System.out.println(arr[9]);
    }

    /**
     * unchecked: NumberFormatException
     */
    public void testUncheck() {
        int i = Integer.parseInt("3422A"); //非检查异常
    }


    public int checkedExceptionMethod(int n) throws IOException { //必须声明
        throw new IOException("IOException");
    }

    public int uncheckExceptionMetho(int n) {
        if (n == 5) {
            throw new RuntimeException("5!");
        }

        return 2;
    }


    public void testFinally2() {
        PrintWriter out = null;

        //利用finnaly 可靠关闭文件
        try {
            out = new PrintWriter("/etc/testf.txt", "utf-8");
            out.println("test");
            System.out.println("输出结束！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("输出错误");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }



    public void testException1() {
        try {
            PrintWriter out = new PrintWriter("te.txt");
            out.println("Hi");
            out.close();
        } catch (IOException e) {
            System.out.println("没有打开的文件" + e.getMessage());
        }
    }


    /**
     * finally总会执行
     */
    public void testFinally() {
        System.out.println(toNumber("55"));
        System.out.println(toNumber(null));
        System.out.println(toNumber(""));

    }


    /**
     * 说明finally功能的方法
     */
    public int toNumber(String s) {
        try {
            char c = s.charAt(0);
            return c - '0'; //'0'的编码是48， 'A’的编码是65
        } catch (NullPointerException e) {
            return -1;
        } catch (RuntimeException e) {
            return -2;
        } finally {    //无论异常是否发生， 总会执行
            return 0;    //覆盖返回值缓冲区中的返回值， 结果总会返回0
        }
    }


}
