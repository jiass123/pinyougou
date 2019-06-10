package com.asiainfo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Produce {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("112.35.22.232");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        // 创建连接
        Connection connection = connectionFactory.newConnection();

        // 通过connection 创建channel
        Channel channel = connection.createChannel();

        // 发送消息
        channel.basicPublish("exchange_myConsumer_test","abc.queue",null,"zhangsan".getBytes());

        // 关闭相关的连接
        channel.close();
        connection.close();
    }
}
