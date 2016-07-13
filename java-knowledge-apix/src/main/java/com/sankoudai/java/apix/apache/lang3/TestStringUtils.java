package com.sankoudai.java.apix.apache.lang3;

import junit.framework.TestCase;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.Arrays;


public class TestStringUtils extends TestCase {
    private static final String BlankString = " \r\n\n\t\r";

    public void testBlank() {
        Assert.assertTrue(StringUtils.isBlank(BlankString));
        Assert.assertTrue(StringUtils.isBlank(null));
        Assert.assertTrue(!StringUtils.isBlank("0"));
    }

    public void testEmpty() {
        Assert.assertTrue(StringUtils.isEmpty(""));
        Assert.assertTrue(!StringUtils.isEmpty(" "));
    }

    public void testAbbreviate() {
        //abbrievate
        Assert.assertEquals("01...", StringUtils.abbreviate("0123456789", 5));
        Assert.assertEquals("01**67", StringUtils.abbreviateMiddle("01234567", "**", 6));
    }

    public void testCenter() {
        //center
        Assert.assertEquals("  012345  ", StringUtils.center("012345", 10));
        Assert.assertEquals("**012345**", StringUtils.center("012345", 10, '*'));
    }

    public void testTrim() {
        Assert.assertEquals(null, StringUtils.trimToNull(BlankString));
        Assert.assertEquals(null, StringUtils.trimToNull(null));
        Assert.assertEquals("012345", StringUtils.trimToNull(BlankString + "012345" + BlankString));

        Assert.assertEquals("", StringUtils.trimToEmpty(BlankString));
        Assert.assertEquals("", StringUtils.trimToEmpty(null));
        Assert.assertEquals("012345", StringUtils.trimToEmpty(BlankString + "012345" + BlankString));
    }

    public void testChomp() {
        //remove line ending
        Assert.assertEquals("012345 ", StringUtils.chomp("012345 \n"));
        Assert.assertEquals("012345", StringUtils.chomp("012345\r\n"));
        Assert.assertEquals("012345", StringUtils.chomp("012345\r"));

        Assert.assertNotEquals("0123456", StringUtils.chomp("012345\r\r"));
        Assert.assertNotEquals("0123456", StringUtils.chomp("\r012345\r"));
    }

    public void testAppend() {
        //append
        Assert.assertEquals("abc.txt", StringUtils.appendIfMissing("abc", ".txt", ".txt"));
        Assert.assertEquals("abc.txt", StringUtils.appendIfMissing("abc.txt", ".txt", ".txt"));
        Assert.assertEquals(".txtabc.txt", StringUtils.appendIfMissing(".txtabc", ".txt", ".txt"));
    }

    public void testSplit() {
        String input = "0 1,2.3|4 5";
        Assert.assertEquals(ArrayUtils.toArray("0", "1", "2", "3", "4", "5"), StringUtils.split(input, " ,.|"));
        System.out.println(Arrays.toString(StringUtils.split("0\n\r 1\r\n 2")));
    }

    public void testSubstring() {
        Assert.assertEquals("ABC", StringUtils.substringBetween("1234ABC4567", "1234", "4567"));
        Assert.assertEquals(null, StringUtils.substringBetween("1234ABC4567", "12345", "4567"));

        Assert.assertEquals("BCD", StringUtils.substringBetween("1234BCD45671234ABC4567", "1234", "4567"));
    }

    public void testRepeat(){
        Assert.assertEquals("****", StringUtils.repeat("*", 4));
    }

    public void testReverse(){
        Assert.assertEquals("543210", StringUtils.reverse("012345"));
    }

    public void testMatch(){
        Assert.assertEquals(3, StringUtils.countMatches("01200", "0"));
        Assert.assertEquals(2, StringUtils.countMatches("1212121", "121"));
    }
}
