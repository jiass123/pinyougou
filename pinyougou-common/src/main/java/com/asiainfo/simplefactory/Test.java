package com.pinyougou.simplefactory;

public class Test {

    public static void main(String[] args) {
        Vedio vedio = VedioFactory.getVedio(JavaVedio.class);
        vedio.play();
    }
}
