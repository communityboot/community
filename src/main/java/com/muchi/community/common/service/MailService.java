package com.muchi.community.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @Author： yuzq
 * @Description: 邮件发送service
 * @Date: 2019/9/18   16:41
 */
@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.from}")
    private String from;

    public void sendMail(String email){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("muchi社区注册验证码");
        simpleMailMessage.setText("521495");
        try {
            mailSender.send(simpleMailMessage);
            System.out.println("发送成功，哈哈哈哈哈哈");
        }catch (Exception e){
            System.out.println("发送失败了！！！！！！！！！！！！！");
        }
    }
}
