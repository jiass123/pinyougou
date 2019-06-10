package com.asiainfo.lambda;

public class LambdaDemo {

    public static void main(String[] args) {
        Interface1 i1 = (i) -> i*2;
        Interface1 i2 = i -> i*2;
        Interface1 i3 = (i) -> {
            System.out.println(i);
            return i*2;
        };
    }
}

/**
 * 单方法接口注解
 */
@FunctionalInterface
interface Interface1 {
    int doubleNum(int i);
}