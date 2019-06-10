package com.asiainfo.singlethreadloacl;

public class Test {

    public static void main(String[] args) {
        System.out.println( ThreadLoaclInstance.getInstance());
        System.out.println( ThreadLoaclInstance.getInstance());
        System.out.println( ThreadLoaclInstance.getInstance());
        new Thread(()->{
            System.out.println( ThreadLoaclInstance.getInstance());
        }).start();
        new Thread(()->{
            System.out.println( ThreadLoaclInstance.getInstance());
        }).start();
    }
}
