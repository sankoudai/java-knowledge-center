package com.sankoudai.java.basics.oop;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author : sankoudai
 * @version : created at 2015/8/7
 */
public class TestEquals extends TestCase {
    private class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object obj){
            if(this==obj) return true;
            if(obj instanceof Point){
                Point other = (Point) obj;
                return x==other.x && y==other.y;
            }else{
                return false;
            }
        }
    }

    public void testEqual(){
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(1, 3);

        Assert.assertTrue(point1.equals(point2));
        Assert.assertTrue(!point1.equals(point3));
    }
}
