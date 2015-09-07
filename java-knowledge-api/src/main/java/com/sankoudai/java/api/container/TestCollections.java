package com.sankoudai.java.api.container;

import junit.framework.TestCase;

import java.util.*;

/**
 * @author : sankoudai
 * @version : created at 2015/8/11
 */
public class TestCollections extends TestCase {
    /* collection related */

    /*-- list related --*/
    public void testSwap() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 0, 1, 2);

        System.out.printf("testSwap: before swap list = %s \n", list);
        Collections.swap(list, 0, 1);
        System.out.printf("testSwap: after swap list = %s \n", list);
    }

    public void testSort() {
        /* Compare by natural order : for comparable */
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 0, 2, 1);

        System.out.printf("testSort: before sort list=%s \n", list);
        Collections.sort(list);
        System.out.printf("testSort: after sort list=%s \n", list);
        System.out.println();

        /* Compare by comparator */
        list.clear();
        Collections.addAll(list, 0, 2, 1);

        System.out.printf("testSort: before sort list=%s \n", list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {//逆序
                return -(o1 - o2);
            }
        });
        System.out.printf("testSort: after sort list=%s \n", list);
        System.out.println();
    }

    public void testShuffle() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 0, 1, 2, 3, 4);

        System.out.printf("testShuffle: before shuffle list = %s \n", list.toString());
        Collections.shuffle(list);
        System.out.printf("testShuffle: after shuffle list = %s \n", list.toString());
        System.out.println();
    }

    /**
     * thread safe wrapper by imposing synchronized access
     */
    public void testSynchronizedCollection() {
        Collection<Object> col = new ArrayList<>();
        col = Collections.synchronizedCollection(col);

        List<Object> list = new ArrayList<>();
        list = Collections.synchronizedList(list);

        Map<Object, Object> map = new HashMap<>();
        map = Collections.synchronizedMap(map);

        Set<Object> set = new HashSet<>();
        set = Collections.synchronizedSet(set);
    }
}
