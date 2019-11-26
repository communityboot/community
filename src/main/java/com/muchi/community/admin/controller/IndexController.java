package com.muchi.community.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/11/26   14:10
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/product")
    public String product(){
        return "portal/product";
    }

    @RequestMapping("/news")
    public String news(){
        return "portal/news";
    }

    @RequestMapping("/case")
    public String casePage(){
        return "portal/case";
    }

    @RequestMapping("/about")
    public String about(){
        return "portal/about";
    }
}
