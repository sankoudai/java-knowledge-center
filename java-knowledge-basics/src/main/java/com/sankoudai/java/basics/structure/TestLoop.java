package com.sankoudai.java.basics.structure;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestLoop extends TestCase{
    public void testFor(){
        for(int i = 0; i<5; i++){
            System.out.printf("for - i = %d  \n", i);
        }
    }

    public void testWhile(){
        while(true){
            System.out.printf("while loop \n");
            break;
        }
    }

    public void testForeach(){
        String[] strings = {"one", "two", "three"};
        for (String i : strings){
            System.out.printf("foreach - item = %s  \n", i);
        }

        Collection<String> collection = new ArrayList<String>();
        Collections.addAll(collection, strings);
        for (String item : collection){
            System.out.printf("foreach - item = %s  \n", item);
        }
    }
}
