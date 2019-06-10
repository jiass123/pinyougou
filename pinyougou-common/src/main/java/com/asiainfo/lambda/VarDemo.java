package com.asiainfo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VarDemo {
    public static void main(String[] args) {
        String s = "abc";
        Consumer<String> consumer = a ->System.out.println(a+"s"+s);

        List<String> list = new ArrayList<>();

    }
}
