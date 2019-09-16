package com.muchi.community.message.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.utils.IpUtils;
import com.muchi.community.common.utils.LayuiVo;
import com.muchi.community.common.utils.MsgResult;
import com.muchi.community.common.utils.UUIDUtil;
import com.muchi.community.message.entity.BaseMessage;
import com.muchi.community.message.service.IBaseMessageService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/msgAddPage")
    public String msgAdd(){
        return "message/msgAddPage";
    }

    @RequestMapping("/addMsg")
    @ResponseBody
    public MsgResult addMsg(@RequestBody BaseMessage baseMessage, HttpServletRequest request){
        if(baseMessage!=null){
            //获取当前操作人姓名
            String username = (String) SecurityUtils.getSubject().getPrincipal();
            //公告需要审核
            baseMessage.setMsgCreator(username);
            baseMessage.setLoginIp(IpUtils.getIpAddr(request));
            baseMessage.setMsgStatus(1);
            baseMessage.setMsgSender(username);
            baseMessage.setMsgReciver(username);
            messageService.save(baseMessage);
            return MsgResult.success();
        }else{
            return MsgResult.fail();
        }
    }

}