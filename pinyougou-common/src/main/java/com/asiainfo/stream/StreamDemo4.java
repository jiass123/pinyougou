package com.asiainfo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo4 {

    public static void main(String[] args) {
        String str = "my name is 007";
        // 在并行流的时候会出现执行混乱
        Stream.of(str.split(" ")).parallel().forEach(System.out::print);
        System.out.println();
        // 在并行流的时候依然是按顺序的
        Stream.of(str.split(" ")).parallel().forEachOrdered(System.out::print);
        System.out.println();
        // 收集器，可以将数组转换为集合
        List<String> collect = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(collect);
        // 连续值的操作
        Optional<String> reduce = Stream.of(str.split(" ")).reduce((x, y) -> x +"|"+ y);
        System.out.println(reduce);
        Optional<Integer> reduce1 = Stream.of(str.split(" ")).map(s -> s.length()).reduce((x, y) -> x + y);
        System.out.println(reduce1);
        // 最大值的操作
        Optional<String> max = Stream.of(str.split(" ")).max((x, y) -> x.length() - y.length());
        System.out.println(max);
        // 短路操作
        Optional<String> first = Stream.of(str.split(" ")).findFirst();
        System.out.println(first);
        System.out.println("------------------------------------------------");
    }
}
