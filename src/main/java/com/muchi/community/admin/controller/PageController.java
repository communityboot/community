package com.muchi.community.admin.controller;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        return "login";
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

    @RequestMapping("/aboutMz")
    public String aboutMz(){
        return "commons/AboutMuZhi";
    }

    @RequestMapping("/index")
    public String index(){
        return "portal/index";
    }

}
