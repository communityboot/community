package com.muchi.community.message.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.utils.LayuiVo;
import com.muchi.community.message.service.IBaseMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  消息系统前端控制器
 * </p>
 *
 * @author yuzq
 * @since 2019-09-07
 */
@Controller
@RequestMapping("/m")
public class BaseMessageController {

    @Autowired
    private IBaseMessageService messageService;

    @RequestMapping("/getAllMessage")
    @ResponseBody
    public LayuiVo getAllMessage(Page page, @RequestParam("limit") int limit, @RequestParam(value = "page", defaultValue = "1") int currentPage) {
        page.setCurrent(currentPage);
        page.setSize(limit);
        return LayuiVo.successLayui(page.getTotal(),messageService.getAllDict(page));
    }

    @RequestMapping("/msgAdd")
    public String msgAdd(){
        return "message/msgAdd";
    }

}
