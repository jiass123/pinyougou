package com.asiainfo.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.impl.AMQBasicProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class PropertiesProduce {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("112.35.22.232");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        // 创建连接
        Connection connection = connectionFactory.newConnection();

        Map<String,Object> headers = new HashMap<>();
        headers.put("a1","b1");
        headers.put("a2","b2");
        // 通过connection 创建channel
        Channel channel = connection.createChannel();
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                // 设置是否持久化 1 持久化 2 不持久化
                .deliveryMode(2)
                // 设置失效时间 单位为毫秒数
                .expiration("10000")
                .headers(headers)
                .build();

        // 发送消息
        channel.basicPublish("","test001",properties,"zhangsan".getBytes());

        // 关闭相关的连接
        channel.close();
        connection.close();
    }
}
