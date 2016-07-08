package com.sankoudai.java.api.regexp;

import org.junit.Assert;
import junit.framework.TestCase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : sankoudai
 * @version : created at 2015/8/16
 */
public class TestRegexp extends TestCase {
    /**
     * () define a group
     */
    public void testGroup() {
        String str = "=abc123=";

        //regexp
        Pattern pattern = Pattern.compile("([a-z]+)([0-9]+)");
        Matcher matcher = pattern.matcher(str);

        //find
        boolean found = matcher.find();
        Assert.assertTrue(found);

        // result groups
        Assert.assertEquals(2, matcher.groupCount());
        Assert.assertEquals("abc123", matcher.group());
        Assert.assertEquals("abc123", matcher.group(0));
        Assert.assertEquals("abc", matcher.group(1));
        Assert.assertEquals("123", matcher.group(2));
    }

    /**
     * (?:) group will not be captured, meaning there is no specific group for it
     * but wil be include in group(0)
     */
    public void testNonCaptureGroup() {
        String str = "=abc123=";

        //regexp
        Pattern pattern = Pattern.compile("(?:[a-z]+)([0-9]+)");
        Matcher matcher = pattern.matcher(str);

        //find
        boolean found = matcher.find();
        Assert.assertTrue(found);

        // result groups
        Assert.assertEquals(1, matcher.groupCount());
        Assert.assertEquals("abc123", matcher.group(0));
        Assert.assertEquals("123", matcher.group(1));
    }

    /**
     * (X)(?=Y): (X) has Y at ahead (won't be captured, and won't appear in global group)
     * (X)(?!Y): (X) doesn't have Y at ahead
     */
    public void testLookAhead() {
        String str = "=abc123=";

        //regexp: positive look ahead
        Pattern pattern = Pattern.compile("(abc)(?=[0-9]+)");
        Matcher matcher = pattern.matcher(str);

        //find
        boolean found = matcher.find();
        Assert.assertTrue(found);


        // result groups
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        Assert.assertEquals(1, matcher.groupCount());
        Assert.assertEquals("abc", matcher.group(0));
        Assert.assertEquals("abc", matcher.group(1));


        //regexp: negative look ahead
        str = "=abc123=";
        pattern = Pattern.compile("(abc)(?![0-9]+)");
        matcher = pattern.matcher(str);

        //find
        found = matcher.find();
        Assert.assertTrue(!found);
    }

    /**
     * (?<=Y)(X):  (X) has Y at behind
     * (?<!Y)(X): (X) doesn't have Y at behind
     */
    public void testLookBehind() {
        String str = "=abc123=";

        //regexp: positive look behind
        Pattern pattern = Pattern.compile("(?<=abc)([0-9]+)");
        Matcher matcher = pattern.matcher(str);

        //find
        boolean found = matcher.find();
        Assert.assertTrue(found);


        // result groups
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        Assert.assertEquals(1, matcher.groupCount());
        Assert.assertEquals("123", matcher.group(0));
        Assert.assertEquals("123", matcher.group(1));


        //regexp: negative look ahead
        str = "=abc123=";
        pattern = Pattern.compile("(?<![a-z]+)(123)");
        matcher = pattern.matcher(str);

        //find
        found = matcher.find();
        Assert.assertTrue(!found);
    }


    /**
     * (?=) and (?!) : confines what's ahead (not passed yet )
     * (?<) and (?<!): confines what's behind (already passed)
     */
    public void testCompareLookAheadAndBehind() {
        // (?!) : confines what's ahead, doesn't confine what's behind
        String str = "=abc123=";
        Pattern pattern = Pattern.compile("(?!abc)(123)");
        Matcher matcher = pattern.matcher(str);

        //find
        boolean found = matcher.find();
        Assert.assertTrue(found);
        Assert.assertEquals(1, matcher.groupCount());

        // (?<!) : confines what's behind
        str = "=abc123=";
        pattern = Pattern.compile("(?<!abc)(123)");
        matcher = pattern.matcher(str);

        //find
        found = matcher.find();
        Assert.assertTrue(!found);
    }


    public void testTemp() {
        Pattern pattern = Pattern.compile("(^(?!visit)(.+))|(^visit.log$)|(visit.log.2016-0[1-4].+)");

        Assert.assertTrue(pattern.matcher("visit.log").find());
        Assert.assertTrue(pattern.matcher("visit.log.2016-03-03").find());
        Assert.assertTrue(pattern.matcher("comment.log").find());
        Assert.assertTrue(pattern.matcher("comment.log.2016-03-03").find());

        Assert.assertTrue(!pattern.matcher("visit.log.2016-05-03").find());

    }
}
