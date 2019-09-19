package com.muchi.community.message.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.log.Log;
import com.muchi.community.common.utils.*;
import com.muchi.community.message.entity.BaseMessage;
import com.muchi.community.message.entity.BaseMessageRecord;
import com.muchi.community.message.service.IBaseMessageRecordService;
import com.muchi.community.message.service.IBaseMessageService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private IBaseMessageRecordService recordService;

    @RequestMapping("/getAllMessage")
    @ResponseBody
    @Log(title = "请求公告所有数据")
    public LayuiVo getAllMessage(Page page, @RequestParam("limit") int limit, @RequestParam(value = "page", defaultValue = "1") int currentPage) {
        page.setCurrent(currentPage);
        page.setSize(limit);
        return LayuiVo.successLayui(page.getTotal(),messageService.getAllDict(page));
    }

    @RequestMapping("/msgAddPage")
    @Log(title = "进入公告新增页面")
    public String msgAdd(){
        return "message/msgAddPage";
    }

    @RequestMapping("/addMsg")
    @ResponseBody
    @Log(title = "新增公告")
    public MsgResult addMsg(@RequestBody BaseMessage baseMessage, HttpServletRequest request){
        if(baseMessage!=null){
            String username = CurrentUserUtil.getCurrentUser().getUserName();
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

    @Log(title = "进入未读消息")
    @RequestMapping("/toUnreadMessage")
    public String toUnreadMessage(Model model){
        List<BaseMessage> unreadMsg= messageService.getUnreadMsg();
        if(unreadMsg!=null){
            model.addAttribute("unreadMsg",unreadMsg);
            return "message/unReadMessage";
        }
        return "message/noMessage";

    }

    @RequestMapping("/getUnreadMsgDetail/{id}")
    @Log(title = "进入公告详情")
    public String getUnreadMsgDetail(@PathVariable("id") Integer id,Model model){
        BaseMessage unreadMsgDetail = messageService.getUnreadMsgDetail(id);
        model.addAttribute("msgDetail",unreadMsgDetail);
        BaseMessageRecord messageRecord=new BaseMessageRecord();
        messageRecord.setUserId(CurrentUserUtil.getCurrentUser().getId());
        messageRecord.setIsRead(1);
        messageRecord.setMsgId(id);
        messageRecord.setReadTime(new Date());
        recordService.saveOrUpdate(messageRecord);
        return "message/messageDetail";
    }

}
