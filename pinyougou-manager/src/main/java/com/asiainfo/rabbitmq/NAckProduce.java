package com.asiainfo.rabbitmq;

import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.AMQBasicProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class NAckProduce {

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

        Map<String,Object> header = new HashMap<String,Object>();

        // 发送消息
        for (int i = 0 ; i < 5 ;i++){
            header.put("num",i);
            AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                    .deliveryMode(2)
                    .headers(header).build();
            channel.basicPublish("exchange_nack_test","ack.queue",properties,"zhangsan".getBytes());
        }

        channel.close();
        connection.close();
    }
}
