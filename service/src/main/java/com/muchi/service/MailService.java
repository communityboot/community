package com.muchi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/25   19:40
 */
@Service
public class MailService {
    @Autowired
    private JavaMailSender sender;

    @Value("${mail.from}")
    private String from;

    @Value("${mail.to}")
    private String to;

    public void sendMail(String email){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("muchi社区注册验证码");
        simpleMailMessage.setText("521495");
        try {
            sender.send(simpleMailMessage);
            System.out.println("发送成功，哈哈哈哈哈哈");
        }catch (Exception e){
            System.out.println("发送失败了！！！！！！！！！！！！！");
        }
    }

}
