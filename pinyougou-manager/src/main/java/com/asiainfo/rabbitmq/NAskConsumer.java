package com.asiainfo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class NAskConsumer {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.1.234.16");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        // 创建连接
        Connection connection = connectionFactory.newConnection();

        // 通过connection 创建channel
        Channel channel = connection.createChannel();

        // 声明交换机
        channel.exchangeDeclare("exchange_ack_test","topic",true,false,false,null);

        // 声明队列
        channel.queueDeclare("test005",true,false,false,null);

        // 绑定交换机与队列
        channel.queueBind("test005","exchange_ack_test","ack.queue");

        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        channel.basicConsume("test005",true,queueingConsumer);

        while(true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            byte[] body = delivery.getBody();
            System.out.println(new String(body));
        }

    }
}
