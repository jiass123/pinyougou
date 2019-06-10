//package com.asiainfo.rabbitmq;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.QueueingConsumer;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.TimeoutException;
//
//public class DeadConsumer {
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
//        Map<String,Object> argurments = new HashMap<>();
//        argurments.put("x-dead-letter-exchange","dlx.exchange");
//
//        // 声明交换机
//        channel.exchangeDeclare("exchange_dead_test","topic",true,false,false,null);
//
//        // 声明队列时加入参数 参数中带有死信交换机 并声明交换机的名称
//        channel.queueDeclare("test0010",true,false,false,argurments);
//
//        // 绑定交换机与队列
//        channel.queueBind("test0010","exchange_dead_test","dead.queue");
//
//        // 声明一个死信交换机 交换机的名称应该和上面的死信参数相同
//        channel.exchangeDeclare("dlx.exchange","topic",true,false,false,null);
//        // 声明一个死信队列
//        channel.queueDeclare("dead.queue",true, false, false, null);
//        // 交换机与队列进行绑定
//        channel.queueBind("dead.queue","dlx.exchange","#");
//
//        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
//
//        channel.basicConsume("test009",true,queueingConsumer);
//
//        while(true){
//            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
//            byte[] body = delivery.getBody();
//            System.out.println(new String(body));
//        }
//
//    }
//}
