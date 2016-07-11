package com.sankoudai.java.basics.topics;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author : sankoudai
 * @version : created at 2016/4/11
 */
public class TestNumericOperation extends TestCase {
    public void testBitOperator() {
        // 1、左移( << ) 低位补充0
        // 0000 0000 0000 0000 0000 0000 0000 0101: 5
        // 0000 0000 0000 0000 0000 0000 0101 0000: 80
        Assert.assertEquals(5 * 2 * 2 * 2 * 2, 5 << 4);

        //1111 1111 1111 1111 1111 1111 1111 0101:  -10
        //1111 1111 1111 1111 1111 1111 0101 0000:  -160
        Assert.assertEquals(-10 * 2 * 2 * 2 * 2, -10 << 4);


        // 2、右移( >> ) 高位补符号位
        // 0000 0000 0000 0000 0000 0000 0101 0000:  80
        // 0000 0000 0000 0000 0000 0000 0000 0101:  5
        Assert.assertEquals(80 / 2 / 2 / 2 / 2, 80 >> 4);

        //1111 1111 1111 1111 1111 1111 0101 0000:  -160
        //1111 1111 1111 1111 1111 1111 1111 0101:  -10
        Assert.assertEquals(-10, -10 * 2 * 2 * 2 * 2 >> 4);

        //1111 1111 1111 1111 1111 1111 1111 1111: -1
        Assert.assertEquals(-1, -1 >> 3);


        // 3、无符号右移( >>> ) 高位补0
        // 1111 1111 1111 1111 1111 1111 1111 1111: -1
        // 0000 1111 1111 1111 1111 1111 1111 1111: 4026531840
        Assert.assertEquals(268435455, -1 >>> 4);

        // 4、位与( & ): 第一个操作数的的第n位于第二个操作数的第n位如果都是1，那么结果的第n为也为1，否则为0
        // 0101: 5
        // 0011: 3
        // 0101 & 0011: 0001
        Assert.assertEquals(1, 5 & 3);// 结果为0

        // 0101: 5
        // 1111 1111: 0xff (16进制)
        Assert.assertEquals(5, 5 & 0xff);


        // 5、位或( | ):  第一个操作数的的第n位于第二个操作数的第n位 只要有一个是1，那么结果的第n为也为1，否则为0
        // 0000: 0
        // 1111 1111: 0xff
        Assert.assertEquals(0xff, 0 | 0xff);


        // 6、位异或( ^ ): 第一个操作数的的第n位于第二个操作数的第n位 相反，那么结果的第n为也为1，否则为0
        Assert.assertEquals(0, 5 ^ 5);

        // 7、位非( ~ )
        // 操作数的第n位为1，那么结果的第n位为0，反之。
        Assert.assertEquals(0, ~-1);
        System.out.println(0b11111111111111111111111111111111);
    }
}
