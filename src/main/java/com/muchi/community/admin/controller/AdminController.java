package com.muchi.community.admin.controller;

import com.muchi.community.admin.service.IAdminService;
import com.muchi.community.common.log.Log;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
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

    private Logger logger=LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private IAdminService service;

    @RequestMapping("/testInfo")
    public String testInfo(){
        return "index";
    }

    @Log(title = "进入主页操作",action = "Haha")
    @RequestMapping("/mainPage")
    public String toIndex(){
        return "homePage";
    }


}
