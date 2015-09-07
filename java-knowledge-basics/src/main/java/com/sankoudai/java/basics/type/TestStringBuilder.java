package com.sankoudai.java.basics.type;

import junit.framework.TestCase;

public class TestStringBuilder extends TestCase{
	/**
	 * 测试使用StringBuilder
	 */
	public void testStringBuilder(){
		//StringBuilder类:  封装了一个内容可变的字符数组， 提供了字符数组常用方法
		//作用:  替代字符数组的用途
		//[]
		StringBuilder buf = new StringBuilder();
		//[李， 敖]
		buf.append("李敖");
		//[李， 敖， 先， 生]
		// 0    1    2     3
		buf.append("先生");
		buf.insert(2,"是位");
		buf.delete(4,6);
		buf.insert(4, "大师");
		
		
		//转化为String
		String str = buf.toString();
		System.out.println(str);
		
		
		//测试返回值
		StringBuilder buf2 = buf.reverse();
		System.out.println(buf2);
		System.out.println(buf);
		
		
	}

	public void testStringBuilder2(){
		//适合连写
		//StringBuilder API 返回当前对象的引用
		StringBuilder buf = new StringBuilder();
		buf.append("文章").append("的老婆是马伊俐").replace(3,5,"妻子");
		
		String str = buf.toString();
		System.out.println(str);
	}
	
	public void testStringBuilder3(){
		//在Java中， String的动态连接是使用StringBuilder实现的!
		String s1 = "Hello";
		String s2 = s1 + " World" + "!";
		
		//如上代码实际是如下实现的(编译器):
		//String s2 = new StringBuilder(s1).append(" World").append("!").toString();
		//在字符串连接过程中会创建一个StringBuilder对象
		//不建议反复使用+运算， 连接字符(单行除外)
		
		//不建议
		String s="";
		for(int i=0; i<10;i++){
			s += "a";
		}
		
		//建议采用
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10; i++){
			sb.append("a");
		}
		s = sb.toString();
		System.out.println(s);
	}

	
	/**
	 * 使用String来反复连接， 并计时
	 */
	public void testStringBuilder4(){
		long start = System.nanoTime();
		String s = "";
		for(int i=0; i<10000; i++){
			s += "a";
		}
		long end = System.nanoTime();
		System.out.println("String : " + (end-start));
	}
	
	
	/**
	 * 使用StringBuilder来反复连接，并计时
	 */
	public void testStringBuilder5(){
		long start = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10000; i++){
			sb.append("a");
		}
		long end = System.nanoTime();
		System.out.println("StringBuilder : " + (end-start));
	}
	
	
	/**
	 * 测试使用replace
	 * 		功能： 将stringBuilder指定的字符段， 代换成指定的字符串。
	 */
	public void testReplace(){
		StringBuilder sb = new StringBuilder("01234567890");
		sb.replace(7,11, "ab");
		System.out.println(sb);
	}
}


