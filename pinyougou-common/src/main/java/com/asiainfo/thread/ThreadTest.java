package com.asiainfo.thread;

import java.util.Arrays;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("执行开始");
        new Thread(()->{
            Arrays.stream(new int[]{1,2,3}).forEach(i->System.out.println("启动线程开始"+i));
        }).start();
        System.out.println("执行结束");
    }
}
