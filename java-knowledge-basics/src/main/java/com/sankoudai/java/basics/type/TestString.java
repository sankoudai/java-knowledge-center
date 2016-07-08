package com.sankoudai.java.basics.type;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author : sankoudai
 * @version : created at 2015/8/5
 */
public class TestString extends TestCase {
    public void testGetBytes(){
        //空字符串
        String str = "";
        byte[] bytes = str.getBytes();

    }


    public void testType() {
        String str = "abc";
        Assert.assertTrue(str instanceof String);

        Object stringObj = "abc";
        Assert.assertTrue(stringObj instanceof String);
    }

    /**
     * whitespace , line endings will be removed
     */
    public void testTrim() {
        String line = "  abc\n";
        System.out.println(line + " END ");
        System.out.println(line.trim() + " END ");
    }

    public void testSubstring() {
        String str = "01234";

        Assert.assertEquals("123", str.substring(1, 4));
        Assert.assertEquals("1234", str.substring(1));
    }

    /**
     * split(regex): trim trailing empties
     * split(regex, -1): keep trailing empties
     */
    public void testSplit() {
        String line = "0 1 2";
        String[] strs = line.split(" ");
        System.out.println(Arrays.toString(strs));

        line = "0  1  2";
        strs = line.split(" +");
        System.out.println(Arrays.toString(strs));

        line = "0 1  2 3   4";
        strs = line.split("[ ]+");
        System.out.println(Arrays.toString(strs));

        line = "|23|";
        strs = line.split("\\|");
        System.out.println(Arrays.toString(strs));

        line = "12|";
        strs = line.split("\\|");
        System.out.println(Arrays.toString(strs));

        line = "12, 3 ,4 , 5";
        strs = line.split("[\\s]*,[\\s]*");
        System.out.println(Arrays.toString(strs));
    }

    /**
     * 测试contains
     */
    public void testContains() {
        String parentString = "aso";

        String piece = "so";
        Assert.assertTrue(parentString.contains(piece));

        piece = ".so";
        Assert.assertTrue(!parentString.contains(piece));
    }

    /**
     * 测试使用indexOf方法
     * str.indexOf(String s)
     * str.lastIndexOf(String s)
     * str.indexOf(String s, int start)
     */
    public void testIndexOf() {
        String str = "01234567890";

        Assert.assertEquals(0, str.indexOf("0"));
        Assert.assertEquals(10, str.indexOf("0", 1));

        Assert.assertEquals(10, str.lastIndexOf("0"));
    }

    /**
     * 测试API方法返回值
     * String 的API方法， 经常不会改变原对象， 有返回值
     * 使用时， 需要赋值！  原对象不会改变， 引用如果不赋值也不改变
     */
    public void testReturnVal() {
        /*一般有返回值， 需要赋值才能使用！*/
        String file = " photo.png ";
        file.trim();
        System.out.println(file); //结果: "  photo.png  "

        /* String API一般可以连写 */
        if (file.trim().toLowerCase().endsWith(".png")) {
            System.out.println("png文件");
        }
    }

    /**
     * 测试使用String.valueOf
     * 功能: 将任何类型转换为String类型
     * 使用场景: 用于输出和连接字符串等
     */
    public void testValueOf() {
        //经常被隐式调用
        //输出过程解析: System.out.println(n);
        int n = 65;
        String str = String.valueOf(n); // 复杂运算--->“65”
        System.out.println(str);

        // 连接过程解析: str = n + "abc"
        str = n + "abc";
        str = String.valueOf(n) + "abc";
    }

    /**
     * String.format: 将多个元素按照规定的格式组合
     */
    public void testFormat() {
        //限定数字的位数 + 组合
        String formatedString = String.format("%02d:%02d:%02d", 1, 13, 24);
        Assert.assertEquals("01:13:24", formatedString);

        //format null
        String nullString = String.format("the value is null: %s", null);
        System.out.println(nullString);
    }

    /**
     * str1.compareTo(str2) :
     * <0, 如果按照字典序str1较小;
     * 0,  如果字符串相等;
     * >0, str2较大
     */
    public void testCompareTo() {
        Assert.assertTrue(("0002001".compareTo("0002005") < 0));
    }


    public void testTempt() throws UnsupportedEncodingException {
        byte[] bytes = {(byte) 0xF0, (byte) 0x9F, (byte) 0x92, (byte) 0x94};
        String s = new String(bytes, "utf-8");
        System.out.printf("s=%s, len=%s", s, s.length());
        int i = s.codePointAt(1);
        System.out.println(i);
    }
}
