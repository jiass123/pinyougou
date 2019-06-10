package com.asiainfo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.stream();
        list.parallelStream(); // 并行流

        int[] abc = {1,2,3};
        Arrays.stream(abc);

        IntStream.of(abc);
        IntStream.rangeClosed(1,10);

        new Random().ints().limit(10);
        Random random = new Random();
        Stream.generate(()->random.ints()).limit(10);
    }
}
