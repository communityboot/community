package com.muchi.web;

import com.muchi.entity.User;
import com.muchi.service.MailService;
import com.muchi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/25   18:58
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @RequestMapping("/DictTest")
    public String tables(){
        return "dictManage";
    }

    @RequestMapping("/index")
    public String index(){
        return "mainPage";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(){
        return userService.getById(2);
    }

    @RequestMapping("/starter")
    public String starter(){
        return "all-admin-index.html";
    }

    @PostMapping("/register")
    public String zc(User user,@RequestParam("email") String email,@RequestParam("verityCode") String verityCode){
        System.out.println(email);
        mailService.sendMail(email);
        if("521495".equals(verityCode)){
            userService.save(user);
            return "index";
        }else {
            return "error";
        }
    }

    @RequestMapping("/toRegister")
    public String register(){
        return "registerPage";
    }

    @RequestMapping("/getEmail")
    @ResponseBody
    public Map<String,String> getEmail(String email){
        Map<String,String> map=new HashMap<>();
        System.out.println(email);
       if(email.length()>0){
          map.put("result","提交成功");
       }else {
         map.put("result","提交失败");
       }
       return map;
    }
}
