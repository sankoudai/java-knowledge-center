package com.sankoudai.java.api.container;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author : sankoudai
 * @version : created at 2015/8/8
 */
public class TestCollection extends TestCase{
    public void testSize(){
        Collection<Integer> col = new ArrayList<>();
        Assert.assertEquals(0, col.size());
    }

    /** collection contains obj
     * if and only if there exists an element of collection item such that item==obj or item.equals(obj)
     */
    public void testContains(){
        Collection<Object> col = new ArrayList<>();

        /* simple object */
        col.add(1);
        Assert.assertTrue(col.contains(1));

        /* null */
        col.add(null);
        Assert.assertTrue(col.contains(null));

        /* user-defined object with default equals */
        Object obj = new ObjectWithDefaultEquals(),
                alikeObj = new ObjectWithDefaultEquals();
        col.add(obj);
        Assert.assertTrue(col.contains(obj));
        Assert.assertTrue(!col.contains(alikeObj));

        /* user-defined object with user-defined equals */
        obj = new ObjectWithDefinedEquals(0);
        alikeObj = new ObjectWithDefinedEquals(0);
        Object notAlikeObj = new ObjectWithDefinedEquals(1);
        col.add(obj);
        Assert.assertTrue(col.contains(alikeObj));
        Assert.assertTrue(!col.contains(notAlikeObj));
    }

    public void testIsEmpty(){
        Collection<Integer> col = new ArrayList<>();
        Assert.assertTrue(col.isEmpty());
    }

    public void testAdd(){
        Collection<Integer> col = new ArrayList<>();
        col.add(1);
        System.out.printf("col = %s \n", col.toString());
    }

    public void testRemove(){
        Collection<Integer> col = new ArrayList<>();
        col.add(0);
        col.add(1);

        boolean removed = col.remove(1);
        Assert.assertTrue(removed);
        System.out.printf("col = %s \n", col.toString());

        removed = col.remove(2);
        Assert.assertTrue(!removed);
    }

    public void testClear(){
        Collection<Integer> col = new ArrayList<>();
        col.add(0);
        col.add(1);

        col.clear();
        Assert.assertTrue(col.isEmpty());
    }

    public void testForeach(){
        Collection<Integer> col = new ArrayList<>();
        col.add(0);
        col.add(1);

        for(Integer i: col){
            System.out.printf("i=%d \n", i);
        }
    }

    public void testIteratorPattern(){
        Collection<Integer> col = new ArrayList<>();
        col.add(0);
        col.add(1);

        Iterator<Integer> iterator = col.iterator();
        while (iterator.hasNext()){
            Integer item = iterator.next();
            if(item == 1){
                iterator.remove(); // remove current item from array
            }
        }

        System.out.printf("col = %s \n", col); //[0]
    }

    /** What collection holds are references to object.
     *  When referenced object changes, it's seen in collection.
     */
    public void testChangeableItem(){
        Collection<Object> col = new ArrayList<>();

        ArrayList<Integer> changeableItem = new ArrayList<>();
        col.add(changeableItem);
        System.out.printf("Before item changes: col = %s \n", col);

        changeableItem.add(1);
        System.out.printf("Afterm item changes: col = %s \n", col);
    }

    
    public void testToArray(){
        Collection<Integer> col = new ArrayList<>();
        col.add(0);
        col.add(1);

        /* to Object[] */
        Object[] objects = col.toArray();

        /* to Integer[] */
        Integer[] integers = col.toArray(new Integer[0]);
    }

    private class ObjectWithDefaultEquals{

    }

    private class ObjectWithDefinedEquals{
        private Integer id;
        public ObjectWithDefinedEquals(Integer id){
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ObjectWithDefinedEquals that = (ObjectWithDefinedEquals) o;

            return (id == that.id) || (id!=null && id.equals(that.id));
        }
    }
}