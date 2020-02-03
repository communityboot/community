package com.muchi.community.common.rbmq;

import com.muchi.community.common.service.MailService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/3   11:48
 */
@Component
public class RegisterMail {

    @Autowired
    private MailService mailService;

    @RabbitListener(queues = "regist")
    public void handleRegister(Message message){
        Map<String, Object> headers = message.getMessageProperties().getHeaders();
        for (String s : headers.keySet()) {
            System.out.println(s+"--"+headers.get(s));
        }
        mailService.sendMail("1065265077@qq.com");
    }
}
