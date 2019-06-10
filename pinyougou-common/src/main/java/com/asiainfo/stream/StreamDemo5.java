package com.asiainfo.stream;

import org.omg.CORBA.TIMEOUT;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamDemo5 {

    public static void main(String[] args) throws InterruptedException {
        // 产生并行流
        IntStream.range(1, 100).parallel()
                // 每次都执行
                .peek(StreamDemo5::debug)
                // 统计总数
                .count();

        // 产生并行流
        IntStream.range(1,100).parallel()
                .peek(StreamDemo5::debug)
                // 转换为串行流
                .sequential()
                .peek(StreamDemo5::debug2).count();

        // 并行流使用的线程数 设置并行流使用线程个数
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.submit(()->{
            IntStream.range(1, 100).parallel()
                    // 每次都执行
                    .peek(StreamDemo5::debug)
                    // 统计总数
                    .count();
        });
        forkJoinPool.shutdown();

        TimeUnit.MINUTES.sleep(2);
    }

    private static void debug(Integer num) {
        System.out.println(num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void debug2(Integer num) {
        System.err.println(num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
