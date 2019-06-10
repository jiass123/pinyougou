package com.asiainfo.rabbitmq.springboot;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringbootRabbitTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(Object msg , Map properties){
        MessageHeaders messageHeaders = new MessageHeaders(properties);
        Message message = MessageBuilder.createMessage(msg,messageHeaders);
        rabbitTemplate.convertAndSend("exchange1","",message);
    }

}
