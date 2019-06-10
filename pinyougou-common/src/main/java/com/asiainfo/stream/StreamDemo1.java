package com.asiainfo.stream;

import java.util.stream.IntStream;

public class StreamDemo1 {
    public static void main(String[] args) {
        int[] i = {1,2,3};
        int sum = 0;

        // 外部迭代
//        for(int a :i){
//            sum += a;
//        }
//        System.out.println(sum);

        // 内部迭代
//        sum = IntStream.of(i).sum();
//        System.out.println(sum);

        // 中间操作返回流 终止操作返回值
        int sum1 = IntStream.of(i).map(StreamDemo1::doubleNum).sum();
        System.out.println(sum1);

        // 惰性操作 不执行终止操作不进行中间操作
        IntStream.of(i).map(StreamDemo1::doubleNum);

    }

    public static int doubleNum(int i){
        System.out.println("执行了");
        return i*2;
    }

}
