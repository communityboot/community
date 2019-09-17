package com.muchi.community.admin.controller;

import com.muchi.community.admin.service.IAdminService;
import com.muchi.community.common.log.Log;
import com.muchi.community.common.utils.MzResult;
import com.muchi.community.message.service.IBaseMessageService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @Autowired
    private IBaseMessageService messageService;

    @RequestMapping("/testInfo")
    public String testInfo(){
        return "index";
    }

    @Log(title = "进入主页操作")
    @RequestMapping("/mainPage")
    public String toIndex(Model model){
        Integer unReadMessageNum = messageService.getUnReadMessageNum();
        model.addAttribute("UnReadNum",unReadMessageNum);
        return "homePage";
    }


}
