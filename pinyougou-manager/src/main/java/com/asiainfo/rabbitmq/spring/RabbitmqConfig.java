package com.asiainfo.rabbitmq.spring;

import com.asiainfo.rabbitmq.entity.Order;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Configuration
public class RabbitmqConfig {

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost("127.0.0.1");
        cachingConnectionFactory.setVirtualHost("/");
        cachingConnectionFactory.setPort(5672);
        return cachingConnectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue queue001(){
        return new Queue("queue001",true);
    }
    @Bean
    public Queue queue002(){
        return new Queue("pdf_queue",true);
    }
    @Bean
    public Queue queue003(){
        return new Queue("image_queue",true);
    }

    @Bean
    public TopicExchange exchange001(){
        return new TopicExchange("topic001",true,false);
    }
    @Bean
    public TopicExchange exchange002(){
        return new TopicExchange("topic002",true,false);
    }

    @Bean
    public Binding binding001(){
        return BindingBuilder.bind(queue001()).to(exchange001()).with("spring.#");
    }
    @Bean
    public Binding binding002(){
        return BindingBuilder.bind(queue002()).to(exchange002()).with("pdf.#");
    }
    @Bean
    public Binding binding003(){
        return BindingBuilder.bind(queue003()).to(exchange002()).with("image.#");
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(5);
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        container.addQueues(queue001(),queue002(),queue003());
        container.setConsumerTagStrategy(new ConsumerTagStrategy() {
            @Override
            public String createConsumerTag(String queue) {
                return queue+"_"+ UUID.randomUUID().toString();
            }
        });

//        container.setChannelAwareMessageListener(new ChannelAwareMessageListener() {
//            @Override
//            public void onMessage(Message message, Channel channel) throws Exception {
//                System.err.println("接收到消息"+new String(message.getBody()));
//            }
//        });

        // 个性化监听器
//        MessageListenerAdapter  adapter = new MessageListenerAdapter(new MessageDelegate());
//        adapter.setDefaultListenerMethod("consumeMessage");
//        adapter.setMessageConverter(new TextMessageConverter());
//        container.setMessageListener(adapter);

        // 个性化监听器1
//        MessageListenerAdapter  adapter = new MessageListenerAdapter(new MessageDelegate());
//        Map<String, String> queueAndMethodNameMap = new HashMap<>();
//        queueAndMethodNameMap.put("queue001","method001");
//        adapter.setMessageConverter(new TextMessageConverter());
//        adapter.setQueueOrTagToMethodName(queueAndMethodNameMap);
//        container.setMessageListener(adapter);

        // 个性化监听器 转换Map对象
//        MessageListenerAdapter  adapter = new MessageListenerAdapter(new MessageDelegate());
//        adapter.setDefaultListenerMethod("consumeMessage");
//        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
//        adapter.setMessageConverter(converter);
//        container.setMessageListener(adapter);

        // 个性化监听器 转换java对象 方式1
//        MessageListenerAdapter  adapter = new MessageListenerAdapter(new MessageDelegate());
//        adapter.setDefaultListenerMethod("consumeMessage");
//        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
//        DefaultJackson2JavaTypeMapper jackson2JavaTypeMapper = new DefaultJackson2JavaTypeMapper();
//        jackson2JavaTypeMapper.setTrustedPackages("com.asiainfo.rabbitmq.entity");
//        converter.setJavaTypeMapper(jackson2JavaTypeMapper);
//        adapter.setMessageConverter(converter);
//        container.setMessageListener(adapter);

        // 个性化监听器 转换java对象 方式2
        MessageListenerAdapter  adapter = new MessageListenerAdapter(new MessageDelegate());
        adapter.setDefaultListenerMethod("consumeMessage");
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        DefaultJackson2JavaTypeMapper jackson2JavaTypeMapper = new DefaultJackson2JavaTypeMapper();
        jackson2JavaTypeMapper.setTrustedPackages("com.asiainfo.rabbitmq.entity");
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("order", Order.class);
        jackson2JavaTypeMapper.setIdClassMapping(idClassMapping);
        converter.setJavaTypeMapper(jackson2JavaTypeMapper);
        adapter.setMessageConverter(converter);
        container.setMessageListener(adapter);
        return container;
    }
}
