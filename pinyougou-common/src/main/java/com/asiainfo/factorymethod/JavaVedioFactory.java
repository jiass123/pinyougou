package com.asiainfo.factorymethod;

public class JavaVedioFactory extends VedioFactory{
    @Override
    public Vedio getVedio() {
        return new JavaVedio();
    }
}
