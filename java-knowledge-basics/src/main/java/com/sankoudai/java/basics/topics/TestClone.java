package com.sankoudai.java.basics.topics;

import com.sankoudai.java.common.PrintUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : sankoudai
 * @version : created at 2015/9/6
 */
public class TestClone {
    /**
     * Collection 和 Map 是引用的集合, clone方法仅仅复制引用, 不复制值。
     * 所以如果集合中的引用， 指向不可变的对象， 则clone得到的集合不受对原集合操作的影响。
     * 如果集合中的应用， 指向可变的对象， 则clone得到的集合 会受可变对象的操作影响
     * .clone 仅仅复制引用， 不会讲
     */
    @Test
    public void mapCloneTest() {
        //Map<Immutable, Immutable>
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("one", "1");
        map.put("two", "2");
        System.out.printf("TestClone[mapCloneTest]-Map<Immutable, Immutable>: originalMap=%s \n", PrintUtil.toString(map));

        Map<String, String> cloneMap = (Map<String, String>) map.clone();
        System.out.printf("TestClone[mapCloneTest]-Map<Immutable, Immutable>: clonedMap=%s \n", PrintUtil.toString(cloneMap));

        map.put("three", "3");    //map2 不受影响
        System.out.printf("TestClone[mapCloneTest]-Map<Immutable, Immutable>: after originalMap modifed -- originalMap=%s, clonedMap=%s \n", PrintUtil.toString(map), PrintUtil.toString(cloneMap));
        System.out.println();

        //Map<Immutable, Mutable>
        HashMap<String, String[]> cmap = new HashMap<String, String[]>();
        String[] strs = new String[2];
        strs[0] = "1";
        strs[1] = "2";
        cmap.put("one", strs);
        System.out.printf("TestClone[mapCloneTest]-Map<Immutable, Mutable>: originalMap=%s \n", PrintUtil.toString(cmap));

        Map<String, String[]> clonedCmap = (HashMap<String, String[]>) cmap.clone();
        System.out.printf("TestClone[mapCloneTest]-Map<Immutable, Mutable>: clonedMap=%s \n", PrintUtil.toString(clonedCmap));

        strs[1] = "1";        //cmap2收到影响
        System.out.printf("TestClone[mapCloneTest]-Map<Immutable, Mutable>: after originalMap modifed -- originalMap=%s, clonedMap=%s \n", PrintUtil.toString(cmap), PrintUtil.toString(clonedCmap));

    }


    @Test
    public void arrayCloneTest() {
        String[] originalArray = new String[2];
        originalArray[0] = "1";
        originalArray[1] = "2";
        System.out.printf("TestClone[arrayCloneTest]: originalArray=%s \n", PrintUtil.toString(originalArray));

        String[] clonedArray = originalArray.clone();
        System.out.printf("TestClone[arrayCloneTest]: clonedArray=%s \n", PrintUtil.toString(clonedArray));

        originalArray[1] = "1";
        System.out.printf("TestClone[arrayCloneTest]--After originalArray modified: originalArray=%s, clonedArray=%s \n", PrintUtil.toString(originalArray), PrintUtil.toString(clonedArray));

        System.out.println(Arrays.toString(clonedArray));
    }
}
