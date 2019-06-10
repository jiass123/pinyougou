package com.asiainfo.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ReturnProduce {

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

        // 发送消息 参数3 是否设置参数路由失败返回
        channel.basicPublish("exchange_return_test","abc.queue",true,null,"zhangsan".getBytes());
//        channel.basicPublish("exchange_return_test","abc.queue",null,"zhangsan".getBytes());
        channel.addReturnListener(new ReturnListener() {

            // 消息未被发送
            @Override
            public void handleReturn(int replyCode, String relyMsg, String exchange, String routingKey, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
                System.out.println(relyMsg);
                System.out.println(replyCode);
                System.out.println(exchange);
                System.out.println(routingKey);
                System.out.println(basicProperties);
                System.out.println(new String(bytes));
            }
        });
    }
}
