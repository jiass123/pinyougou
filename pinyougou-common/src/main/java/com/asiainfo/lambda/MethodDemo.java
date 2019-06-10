package com.asiainfo.lambda;

import java.util.function.*;

class Dog{
    private String name = "啸天犬";
    private int food = 10;

    public Dog(){
    }


    public Dog(String name){
        this.name = name;
    }

    public static void bark(Dog dog){
        System.out.println(dog+"叫了");
    }

    public int eat(int num){
        food = food-num;
        System.out.println("吃了"+num+"斤，还剩"+food);
        return food;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
public class MethodDemo {

    public static void main(String[] args) {

        Dog dog = new Dog();

        // 方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("你好");

        // 静态方法的方法引用
        Consumer<Dog> consumer2 = Dog::bark;
        consumer2.accept(dog);

        // 非静态方法引用
        IntUnaryOperator operator = dog::eat;
        operator.applyAsInt(2);

        // 使用类名调用非静态方法
        BiFunction<Dog,Integer ,Integer > function = Dog::eat;
        function.apply(dog,2);

        // 无参数构造函数方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println(supplier.get());

        // 有参数构造函数方法因哟乖
        Function<String,Dog> function1 = Dog::new;
        System.out.println(function1.apply("拉布拉多"));
    }
}
