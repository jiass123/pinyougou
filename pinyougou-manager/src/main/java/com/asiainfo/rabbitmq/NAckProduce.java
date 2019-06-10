package com.asiainfo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class NAckProduce {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.1.234.16");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        // 创建连接
        Connection connection = connectionFactory.newConnection();

        // 通过connection 创建channel
        Channel channel = connection.createChannel();

        channel.confirmSelect();
        // 发送消息
        channel.basicPublish("exchange_ack_test","ack.queue",null,"zhangsan".getBytes());

        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {
                System.err.println("ack成功");
            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {
                System.err.println("ack失败");
            }
        });
    }
}
