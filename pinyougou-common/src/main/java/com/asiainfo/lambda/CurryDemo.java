package com.asiainfo.lambda;

import java.util.function.Function;

public class CurryDemo {
    public static void main(String[] args) {

        // 及联表达式
        Function<Integer, Function<Integer, Integer>> function = x -> y -> x + y;
        Integer result = function.apply(1).apply(2);
        System.out.println(result);

        // 柯里化
        Function<Integer, Function<Integer, Function<Integer, Integer>>> function1 = x -> y -> z -> x * y * z;
        System.out.println(function1.apply(1).apply(2).apply(3));

        int[] nums = {1, 2, 3};
        Function f = function1;
        for (int i = 0; i < nums.length; i++) {
            Object apply = f.apply(nums[i]);
            if (apply instanceof Function) {
                f = (Function)apply;
            } else {
                System.out.println("处理完毕" +apply);
            }
        }
    }
}
