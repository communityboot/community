package com.muchi.community.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author： yuzq
 * @Description: 页面控制器
 * @Date: 2019/8/18   21:51
 */
@Controller
public class PageController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }




}
