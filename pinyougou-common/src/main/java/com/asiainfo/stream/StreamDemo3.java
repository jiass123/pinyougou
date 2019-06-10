package com.asiainfo.stream;

import java.util.Random;
import java.util.stream.Stream;

public class StreamDemo3 {

    public static void main(String[] args) {
        String str = "my name is 007";
        // 根据数组创建流
        Stream.of(str.split(" "))
                // 设置过滤数组中内容的条件
                .filter(s -> s.length() > 2)
                // 获取数组中的属性值
                .map(s -> s.length())
                // 循环打印
                .forEach(System.out::println);
        // 根据数组创建流
        Stream.of(str.split(" "))
                // 不理解 但是需要装箱 由intStream -》Stream
                .flatMap(s -> s.chars().boxed())
                .forEach(s->{ System.out.println((char)s.intValue()); });
        // 根据数组创建流
        Stream.of(str.split(""))
                // 每次循环执行中执行一次 好像是
                .peek(System.out::println)
                .forEach(System.out::println);
        // 获取随机数转变为流
        new Random().ints()
                // 过滤条件
                .filter(x -> x >10 && x < 100)
                // 只要10个
                .limit(10).forEach(System.out::println);
    }
}
