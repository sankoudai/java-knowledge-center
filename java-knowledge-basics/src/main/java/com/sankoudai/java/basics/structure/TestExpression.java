package com.sankoudai.java.basics.structure;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestExpression extends TestCase{
    public void testExpression() {
        // arithmetic expression: omitted

        /* relation expression */
        int i=3, j =4, k=5;
        boolean b = (i>k) || (j>k);
        Assert.assertFalse(b);

        /* assignment expression */
        k = (i=2);
        Assert.assertEquals(k, 2);
        boolean b2 = (b=false);
        Assert.assertFalse(b2);


        /* compound expression */
        i = 0;
        j = (i+=2);
        Assert.assertEquals(2, j);

        /* function expression with return value */
        i = returnFunction();


        /* if  clause expression */
        // i= (int) (if(true) {System.out.println("if clause");}); // if clause not exp in java

        /* while clause expression */
        //i = (int) (while(true){break;}); // loop not exp in Java

        /* deal with expression result */
		/*  Java allows you to ignore return value;
		 *   As long as the expression has at leat one side-effect
		 */
        //		i+i2; 	//  won't compile
        //		(i>i2) || true;  // won't compile
        returnFunction(); //has at leat on sideeffect
    }

    private int returnFunction() {
        return 2;
    }
}
