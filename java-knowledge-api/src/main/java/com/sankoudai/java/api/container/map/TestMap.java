package com.sankoudai.java.api.container.map;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : sankoudai
 * @version : created at 2015/8/11
 */
public class TestMap extends TestCase {

    public void testHashCode() {
        String s1 = new String("ABC");
        String s2 = new String("ABC");
        String s3 = new String("Tom");
        String s4 = new String("Jerry");
        String s5 = new String("Andy");

        //两个对象相等时， hashCode()相同的
        Assert.assertTrue(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        //对象不等时， hashCode一般是不同的
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(s5.hashCode());
    }

    public void testKey() {
        /* test equality of key:  new Date(0L) equals new Date(0L) */
        Map<Object, Object> map = new HashMap<>();
        map.put(new Date(0L), "a");
        map.put(new Date(0L), "b");
        Assert.assertEquals(map.size(), 1);
        Assert.assertEquals(map.get(new Date(0L)), "b");

        /* test null key : null key is valid */
        Assert.assertEquals(map.get(null), null);
    }

    public void testEmptyKeySet() {
        Map<Object, Object> map = new HashMap<>();
        Set<Object> keys = map.keySet();

        Assert.assertTrue(keys != null);
        Assert.assertTrue(keys.isEmpty());
    }

    public void testPutAll() {

        Map<Object, Object> anotherMap = new HashMap<>();
        anotherMap.put("name", "jim");
        anotherMap.put("age", 30);

        /* putAll */
        Map<Object, Object> map = new HashMap<>();
        map.putAll(anotherMap);
        System.out.printf("testPutAll: map = %s\n", map.toString());

        /* putAll的覆盖: 后添加的值会覆盖原有值 */
        Map<Object, Object> thirdMap = new HashMap<>();
        thirdMap.put("name", "lilei");
        map.putAll(thirdMap);
        Assert.assertEquals(map.get("name"), "lilei");
    }
}
