package com.sankoudai.java.basics.type;


import junit.framework.TestCase;
import org.junit.Assert;

public class TestNull extends TestCase{
	public void testAdd(){
		String string = null + "a";
		Assert.assertEquals("nulla", string);
	}

	public void testConversion(){
		Object obj = null;
		String string = (String) obj;
		Assert.assertEquals(null, string);
	}
	
	public void testEqual(){
		Object obj = null;
		String obj2 = null;
		Assert.assertTrue(obj == obj2);

		/* 字符串和null的相等 */
		Assert.assertFalse("string".equals(null));
	}
}
