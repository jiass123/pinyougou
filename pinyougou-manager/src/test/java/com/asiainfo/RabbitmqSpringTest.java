//package com.asiainfo;
//
//import com.asiainfo.rabbitmq.entity.Order;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.amqp.AmqpException;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.HashMap;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RabbitmqSpringTest {
//
//    @Autowired
//    private RabbitAdmin rabbitAdmin;
//
//    @Test
//    public void test1(){
//        rabbitAdmin.declareExchange(new DirectExchange("test.direct.exchange",false,false,new HashMap<>()));
//        rabbitAdmin.declareExchange(new FanoutExchange("test.fanout.exchange",false,false,new HashMap<>()));
//        rabbitAdmin.declareExchange(new TopicExchange("test.topic.exchange",false,false,new HashMap<>()));
//
//        rabbitAdmin.declareQueue(new Queue("test.direct.queue",false,false,false,new HashMap<>()));
//        rabbitAdmin.declareQueue(new Queue("test.fanout.queue",false,false,false,new HashMap<>()));
//        rabbitAdmin.declareQueue(new Queue("test.fanout2.queue",false,false,false,new HashMap<>()));
//        rabbitAdmin.declareQueue(new Queue("test.topic.queue",false,false,false,new HashMap<>()));
//        rabbitAdmin.declareQueue(new Queue("test.topic2.queue",false,false,false,new HashMap<>()));
//
//        rabbitAdmin.declareBinding(new Binding("test.direct.queue",Binding.DestinationType.QUEUE,"test.direct.exchange","direct.#",new HashMap<>()));
//        rabbitAdmin.declareBinding(new Binding("test.fanout.queue",Binding.DestinationType.QUEUE,"test.fanout.exchange","",new HashMap<>()));
//        rabbitAdmin.declareBinding(new Binding("test.topic.queue",Binding.DestinationType.QUEUE,"test.topic.exchange","topic.#",new HashMap<>()));
//
////        rabbitAdmin.purgeQueue("session_queue");
//
//        rabbitAdmin.declareBinding(BindingBuilder
//                .bind(new Queue("test.topic2.queue",false))
//                .to(new TopicExchange("test.topic.exchange",false,false))
//                .with("topic2.#"));
//
//        rabbitAdmin.declareBinding(BindingBuilder
//                .bind(new Queue("test.fanout2.queue",false))
//                .to(new FanoutExchange("test.fanout.exchange",false,false,new HashMap<>())));
//    }
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Test
//    public void test2(){
//
////        MessageProperties messageProperties = new MessageProperties();
////        messageProperties.getHeaders().put("desc", "描述1");
////        messageProperties.setContentType("text/plain");
////        Message message = new Message("hello rabbitmq".getBytes(),messageProperties);
////        rabbitTemplate.send("topic001","spring.create",message);
//
////        rabbitTemplate.convertAndSend("topic002", "pdf.delete", "hello rabbitmq2", new MessagePostProcessor() {
////            @Override
////            public Message postProcessMessage(Message message) throws AmqpException {
////                message.getMessageProperties().setContentType("text/plain");
////                message.getMessageProperties().getHeaders().put("desc","abc");
////                return message;
////            }
////        });
//
//        MessageProperties messageProperties = new MessageProperties();
//        messageProperties.setContentType("application/json");
//        messageProperties.getHeaders().put("__TypeId__","order");
////        messageProperties.getHeaders().put("__TypeId__","com.asiainfo.rabbitmq.entity.Order");
//        Order order = new Order();
//        order.setOrderId(1);
//        order.setOrderName("工单1");
//        order.setOrderAddress("工单地址1");
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = null;
//        try {
//            s = objectMapper.writeValueAsString(order);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        System.err.println(s);
//        Message message = new Message(s.getBytes(),messageProperties);
//        rabbitTemplate.convertAndSend("topic001","spring.create",message);
//    }
//}
