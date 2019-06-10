package com.asiainfo.rabbitmq.spring;

import com.asiainfo.rabbitmq.entity.Order;

import java.util.Map;

public class MessageDelegate {

//    public void handleMessage(String message){
//        System.err.println("消息接收到了"+message);
//    }

    public void consumeMessage(byte[] message){
        System.err.println("消息接收到了"+message);
    }

    public void method001(String message){
        System.err.println("method001方法接收到了消息"+message);
    }

    public void consumeMessage(Map map){
        System.err.println("map消息接收到了"+map);
    }

    public void consumeMessage(Order order){
        System.err.println("order消息接收到了"+order);
    }
}
