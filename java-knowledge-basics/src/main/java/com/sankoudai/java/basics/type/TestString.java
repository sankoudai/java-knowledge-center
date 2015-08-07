package com.sankoudai.java.basics.type;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

/**
 * @author : sankoudai
 * @version : created at 2015/8/5
 */
public class TestString extends TestCase {
    public void testType(){
        String str = "abc";
        Assert.assertTrue(str instanceof String);

        Object stringObj = "abc";
        Assert.assertTrue(stringObj instanceof String);
    }

    /**whitespace + line endings will be removed*/
    public void testTrim() {
        String line = "  abc\n";
        System.out.println(line + " END ");
        System.out.println(line.trim() + " END ");
    }

    public void testSubstring(){
        System.out.println("*" + "0123".substring(4) + "*");
    }

    /**split(regex) */
    public void testSplit(){
        /* Single spaced words */
        String line = "word0 word1 word2 SingleSpace NoTrailing";
        String[] strs = line.split(" ");
        System.out.println(Arrays.toString(strs));

        /* Double spaced word */
        System.out.println("*******Double spaced word******");
        line = "word0  word1  word2  DoubleSpace  NoTrailing";
        strs = line.split(" +");
        System.out.println(Arrays.toString(strs));

        /* Multiple spaced word */
        System.out.println("*******Multiple spaced word******");
        line = "word0  word1  word2  DoubleSpace  NoTrailing";
        strs = line.split("[ ]+");
        System.out.println(Arrays.toString(strs));
    }
}
