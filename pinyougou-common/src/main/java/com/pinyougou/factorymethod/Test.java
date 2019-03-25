package com.pinyougou.factorymethod;

public class Test {

    public static void main(String[] args) {
        VedioFactory vedioFactory = new JavaVedioFactory();
        Vedio vedio = vedioFactory.getVedio();
        vedio.play();
    }
}
