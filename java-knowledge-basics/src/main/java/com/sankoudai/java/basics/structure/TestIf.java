package com.sankoudai.java.basics.structure;

import junit.framework.TestCase;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestIf extends TestCase {
    public void testIf(){
        if(true){
            System.out.printf("true \n");
        }else{
            System.out.printf("false \n");
        }
    }

    public void testTernaryOperator(){
        int i = 3 > 2 ? 1 : 0;
        System.out.printf("Ternary operator -- i = %d", i);
    }
}
