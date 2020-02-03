package com.muchi.community.common.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/3   12:09
 */
@Configuration
public class RbmqConfig {

    @Bean
    public RabbitTemplate rabbitTemplate( ConnectionFactory connectionFactory){
        return new RabbitTemplate(connectionFactory);
    }

        /*  @Value("${spring.rabbitmq.host}")
    private  String URL;

    @Value("${spring.rabbitmq.username}")
    private  String USERNAME;

    @Value("${spring.rabbitmq.password}")
    private  String PWD;

    @Value("${spring.rabbitmq.virtual-host}")
    private  String VIRTUAL_HOST;

    @Bean
    public ConnectionFactory getConnect(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setAddresses(URL);
        cachingConnectionFactory.setUsername(USERNAME);
        cachingConnectionFactory.setPassword(PWD);
        cachingConnectionFactory.setVirtualHost(VIRTUAL_HOST);
        return cachingConnectionFactory;
    }*/
}
