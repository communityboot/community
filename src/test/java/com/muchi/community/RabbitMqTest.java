package com.muchi.community;

import com.muchi.community.common.service.MailService;
import com.muchi.community.common.utils.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/3   11:24
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMqTest {

    @Autowired
    private RabbitMqUtil rabbitMqUtil;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    private MailService mailService;

    @Test
    public void testMq() throws Exception {
        Connection connect = rabbitMqUtil.getConnect();
        Channel channel = connect.createChannel();
        channel.exchangeDeclare("exc-topic", "topic");
        String msg = "Hello direct add";
        channel.basicPublish("exc-topic", "item.add", null, msg.getBytes());
        channel.close();
        connect.close();
    }

    @Test
    public void sendTemp(){
        rabbitTemplate.convertAndSend("register","reg","注册成功了！！！！！！！！！！");
        System.out.println("ccc");
    }

    @Test
    public void testRbq() throws UnsupportedEncodingException {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.getHeaders().put("desc", "信息描述..");
        messageProperties.getHeaders().put("type", "自定义消息类型..");
        Message message = new Message("Hello RabbitMQaa".getBytes(), messageProperties);
            rabbitTemplate.convertAndSend("register", "spring.amqp", message);
    }

    @Test
    public void sendEmail(){
        mailService.sendMail("1065265077@qq.com");
        System.out.println("发送成功");
    }
}
