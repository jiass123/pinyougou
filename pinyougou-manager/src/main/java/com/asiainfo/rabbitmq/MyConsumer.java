package com.asiainfo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MyConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("112.35.22.232");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("exchange_myConsumer_test","topic",true,false,false,null);
        channel.queueDeclare("test006",true,false,false,null);
        channel.queueBind("test006","exchange_myConsumer_test","abc.queue");
        channel.basicConsume("test006",true,new MyConsumerListener(channel));
    }
}
