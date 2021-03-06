package com.asiainfo.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyConsumerListener3 extends DefaultConsumer {

    private Channel channel;

    public MyConsumerListener3(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        System.out.println(consumerTag);
        System.out.println(envelope);
        System.out.println(properties);
        System.out.println(body);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//         参数1 消息标志 参数2 是否批量 这个参数需要在basicQos的第二个参数不为1的是否有效
        if(0 == (int)properties.getHeaders().get("num")){
            // 参数1 消息标志 参数2 是否批量 参数3 是否重回队列（重回到消息的末尾）
            channel.basicNack(envelope.getDeliveryTag(),false,true);
        }else{
            channel.basicAck(envelope.getDeliveryTag(),false);
        }
        System.out.println(properties.getHeaders().get("num"));
    }
}
