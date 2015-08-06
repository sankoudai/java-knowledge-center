package basics.type;

import junit.framework.TestCase;

/**
 * @author : sankoudai
 * @version : created at 2015/8/5
 */
public class TestInt extends TestCase {
    public void testValue(){
        int i = 10;
        System.out.printf("int : %d \n", i);

        int hexInt = 0xff;
        System.out.printf("int: 0xff=%d \n", hexInt);
    }

    public void testMaxValue(){
        int maxInt = Integer.MAX_VALUE;
        System.out.printf("maxInt = %d, about 2billion \n", maxInt);
    }

    public void testOverflow(){
        int maxInt = Integer.MAX_VALUE;
        System.out.printf(" maxInt + 1 = %d \n", maxInt + 1);
        System.out.println("So int set forms a ring!!");
    }
}
