package com.sankoudai.java.api;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLog {

    public void exec(){
        String uuid=UUID.randomUUID().toString();
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(uuid);
    }


    public static void main(String[] args) {
//        final TestLog testLog=new TestLog();
//        ExecutorService service= Executors.newCachedThreadPool();
//        for(int i=0;i<60;i++){
//
//            service.execute(new Runnable() {
//                @Override
//                public void run() {
////                    testLog.exec();
//                    Object o1=new Object();
//                    Object o2=new Object();
//                    Object o3=o1;
//                    System.out.println(o3);
//                    o3=o2;
//                    System.out.println(o3);
//                }
//            });
//        }

        Object o1=new Object();
        Object o2=new Object();
        Object o3=o1;
        System.out.println(o3);
        o3=o2;
        System.out.println(o3);
    }
}