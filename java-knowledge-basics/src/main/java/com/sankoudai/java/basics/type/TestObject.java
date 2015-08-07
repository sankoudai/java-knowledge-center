package com.sankoudai.java.basics.type;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author : sankoudai
 * @version : created at 2015/8/5
 */
public class TestObject extends TestCase{

    /** 对象的默认值:  对象-null, boolean-false, number-0 */
    public void testDefaultAttributeValue(){
        ExampleObject exampleObject = new ExampleObject();
        Assert.assertEquals(null, exampleObject.getObjectVar());
        Assert.assertEquals(false, exampleObject.isBooleanVar());
        Assert.assertEquals((byte)0, exampleObject.getByteVar());
        Assert.assertEquals((short)0, exampleObject.getShortVar());
        Assert.assertEquals(0, exampleObject.getIntVar());
        Assert.assertEquals(0L,exampleObject.getLongVar());
        Assert.assertTrue(Math.abs(0.0f-exampleObject.getFloatVar()) < 0.0001);
        Assert.assertTrue(Math.abs(0.0 -exampleObject.getDoubleVar()) < 0.0001);
    }
}

class ExampleObject{
    private Object objectVar;
    private boolean booleanVar;
    private byte byteVar;
    private short shortVar;
    private int intVar;
    private long longVar;
    private float floatVar;
    private double doubleVar;

    public Object getObjectVar() {
        return objectVar;
    }

    public void setObjectVar(Object objectVar) {
        this.objectVar = objectVar;
    }

    public boolean isBooleanVar() {
        return booleanVar;
    }

    public void setBooleanVar(boolean booleanVar) {
        this.booleanVar = booleanVar;
    }

    public byte getByteVar() {
        return byteVar;
    }

    public void setByteVar(byte byteVar) {
        this.byteVar = byteVar;
    }

    public short getShortVar() {
        return shortVar;
    }

    public void setShortVar(short shortVar) {
        this.shortVar = shortVar;
    }

    public int getIntVar() {
        return intVar;
    }

    public long getLongVar() {
        return longVar;
    }

    public void setLongVar(long longVar) {
        this.longVar = longVar;
    }

    public void setIntVar(int intVar) {
        this.intVar = intVar;
    }

    public float getFloatVar() {
        return floatVar;
    }

    public void setFloatVar(float floatVar) {
        this.floatVar = floatVar;
    }

    public double getDoubleVar() {
        return doubleVar;
    }

    public void setDoubleVar(double doubleVar) {
        this.doubleVar = doubleVar;
    }
}