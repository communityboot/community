package com.muchi.community.admin.controller;

import com.muchi.community.admin.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuzq
 * @since 2019-08-13
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService service;

    @RequestMapping("/testInfo")
    public String testInfo(){
        return "index";
    }

    @RequestMapping("/mainPage")
    public String toIndex(){
        return "homePage";
    }


    @RequestMapping("/toFragment")
    public String toFragment(){
        return "fragment";
    }

}
