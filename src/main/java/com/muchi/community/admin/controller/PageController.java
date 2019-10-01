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

    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }


    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/druidMonitor")
    public String druidMonitor(){
        return "/admin/druid";
    }

    @RequestMapping("/message")
    public String messagePage(){
        return "message/message";
    }

    @RequestMapping("/frame")
    public String Frame(){
        return "commons/Frame";
    }

    @RequestMapping("/Mainframe")
    public String Mainframe(){
        return "portal/MainFrame";
    }

    @RequestMapping("/userAdd")
    public String userAdd(){
        return "admin/userAdd";
    }

    @RequestMapping("/aboutMz")
    public String aboutMz(){
        return "commons/AboutMuZhi";
    }

}
