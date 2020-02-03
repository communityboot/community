package com.muchi.community.common.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/3   10:58
 */
@Component
public class RabbitMqUtil {

    @Value("${spring.rabbitmq.host}")
    private  String URL;

    @Value("${spring.rabbitmq.username}")
    private  String USERNAME;

    @Value("${spring.rabbitmq.password}")
    private  String PWD;

    @Value("${spring.rabbitmq.virtual-host}")
    private  String VIRTUAL_HOST;

    public  Connection getConnect(){
        Connection connection=null;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(URL);
        factory.setPort(5672);
        factory.setUsername(USERNAME);
        factory.setPassword(PWD);
        factory.setVirtualHost(VIRTUAL_HOST);
        try {
            connection = factory.newConnection();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
