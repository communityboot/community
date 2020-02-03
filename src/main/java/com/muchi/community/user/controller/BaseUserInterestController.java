package com.muchi.community.user.controller;


import com.muchi.community.user.service.IBaseUserInterestService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuzq
 * @since 2019-09-14
 */
@Controller
@RequestMapping("/user")
public class BaseUserInterestController {

    @Autowired
    private IBaseUserInterestService interestService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     *
     * @return 查找所有的兴趣爱好分组
     */
    @GetMapping("/getUserIdsByInterest")
    @ResponseBody
    List<Map<String,String>> getUserIdsByInterest(){
        return interestService.getUserIdsByInterest();
    }

    @RequestMapping("/testParam")
    @ResponseBody
    public List<String> testParam(@RequestParam("name") String name){
        return interestService.testParam(name);
    }
    @RequestMapping("/queryIdsByInterest")
    @ResponseBody
    public List<String> queryIdsByInterest(@RequestParam("ids") String ids) {
        return interestService.queryIdsByInterest(ids);
    }

    @RequestMapping("/sendMsg")
    public void sendMsg(){
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.getHeaders().put("desc", "信息描述..");
        messageProperties.getHeaders().put("type", "自定义消息类型..");
        Message message = new Message("Hello RabbitMQaa".getBytes(), messageProperties);
        rabbitTemplate.convertAndSend("register", "spring.amqp", message);
    }

}
