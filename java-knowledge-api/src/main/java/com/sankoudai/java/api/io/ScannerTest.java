package com.sankoudai.java.api.io;

import junit.framework.TestCase;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;

/**
 * @author : sankoudai
 * @version : created at 2015/8/6
 */
public class ScannerTest extends TestCase{
    public void testBuild(){
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);
        scanner.close();

        scanner = new Scanner(inputStream, "utf-8");
        scanner.close();

        Reader reader = new StringReader("test");
        scanner = new Scanner(reader);
        scanner.close();
    }

    public void testNextField(){
        /*next string*/
        Reader reader = new StringReader("Hello, my friend.");
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()){
            String field = scanner.next();
            System.out.printf("field=%s ", field);
        }
        scanner.close();
        System.out.println();

        /*next double*/
        reader = new StringReader("12 13");
        scanner = new Scanner(reader);
        while (scanner.hasNext()){
            double doubleField = scanner.nextDouble();
            System.out.printf("doubleField=%s ", doubleField);
        }
        scanner.close();
    }

    public void testNextLine(){
        Reader reader = new StringReader("Hello, my friend. \nIt's been a long time");
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            System.out.printf("line=%s \n", line);
        }
        scanner.close();
    }
}
