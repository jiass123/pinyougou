//package com.asiainfo.rabbitmq;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.QueueingConsumer;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
//public class QosConsumer {
//
//    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
//        // 创建连接工厂
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost("112.35.22.232");
//        connectionFactory.setPort(5672);
//        connectionFactory.setVirtualHost("/");
//
//        // 创建连接
//        Connection connection = connectionFactory.newConnection();
//
//        // 通过connection 创建channel
//        Channel channel = connection.createChannel();
//
//        // 声明交换机
//        channel.exchangeDeclare("exchange_qos_test","topic",true,false,false,null);
//
//        // 声明队列
//        channel.queueDeclare("test007",true,false,false,null);
//
//        // 绑定交换机与队列
//        channel.queueBind("test007","exchange_qos_test","qos.queue");
//
//        // 设置qos 参数1 表示消息的大小限制 参数2 表示消息的数量 参数3 consumer/channel
//        channel.basicQos(0,1,false);
//        channel.basicConsume("test007",false,new MyConsumerListener2(channel));
//    }
//}
