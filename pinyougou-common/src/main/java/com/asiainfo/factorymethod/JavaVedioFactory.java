package com.pinyougou.factorymethod;

public class JavaVedioFactory extends VedioFactory{
    @Override
    public Vedio getVedio() {
        return new JavaVedio();
    }
}
