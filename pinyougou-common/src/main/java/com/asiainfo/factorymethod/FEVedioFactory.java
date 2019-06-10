package com.asiainfo.factorymethod;

public class FEVedioFactory extends VedioFactory{
    @Override
    public Vedio getVedio() {
        return new FEVedio();
    }
}
