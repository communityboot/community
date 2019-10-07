package com.muchi.community.message.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.constant.BusinessType;
import com.muchi.community.common.constant.JsonConstant;
import com.muchi.community.common.log.Log;
import com.muchi.community.common.utils.*;
import com.muchi.community.message.entity.BaseMessage;
import com.muchi.community.message.entity.BaseMessageRecord;
import com.muchi.community.message.service.IBaseMessageRecordService;
import com.muchi.community.message.service.IBaseMessageService;
import com.muchi.community.user.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
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
    @Log(title = "请求公告所有数据",action = BusinessType.SELECT)
    public LayuiVo getAllMessage(Page page, @RequestParam("limit") int limit, @RequestParam(value = "page", defaultValue = "1") int currentPage) {
        page.setCurrent(currentPage);
        page.setSize(limit);
        return LayuiVo.successLayui(page.getTotal(),messageService.getAllDict(page));
    }

    @RequestMapping("/searchMsg")
    @ResponseBody
    @Log(title = "搜索消息功能",action = BusinessType.SELECT)
    public LayuiVo searchMsg(@RequestParam("limit") int limit, @RequestParam(value = "page", defaultValue = "1") int currentPage, BaseMessage baseMessage) {
      Page<BaseMessage> page=new Page<>(currentPage,limit);
        QueryWrapper<BaseMessage> wrapper=new QueryWrapper<>();
        if(baseMessage!=null){
            wrapper.lambda().eq(baseMessage.getMsgType()!=null,BaseMessage::getMsgType,baseMessage.getMsgType())
                            .eq(baseMessage.getMsgStatus()!=null,BaseMessage::getMsgStatus,baseMessage.getMsgStatus())
                            .eq(baseMessage.getMsgCreator()!=null,BaseMessage::getMsgCreator,baseMessage.getMsgCreator())
                            .eq(baseMessage.getMsgTitle()!=null,BaseMessage::getMsgTitle,baseMessage.getMsgTitle());}
        IPage<BaseMessage> ipage = messageService.searchMsg(page, wrapper);
        return LayuiVo.successLayui(page.getTotal(),ipage.getRecords());
    }

    @RequestMapping("/msgAddPage")
    @Log(title = "进入公告新增页面",action = BusinessType.SELECT)
    public String msgAdd(){
        return "message/msgAddPage";
    }

    @RequestMapping("/addMsg")
    @ResponseBody
    @Log(title = "新增公告",action = BusinessType.ADD)
    public MzResult addMsg(@RequestBody BaseMessage baseMessage, HttpServletRequest request){
        if(baseMessage!=null){
            String username = CurrentUserUtil.getCurrentUser().getUserName();
            baseMessage.setId(UUIDUtil.genUUID());
            baseMessage.setMsgCreator(username);
            baseMessage.setLoginIp(IpUtils.getIpAddr(request));
            baseMessage.setMsgStatus(1);
            baseMessage.setMsgSender(username);
            baseMessage.setMsgReciver(username);
            messageService.save(baseMessage);
            return MzResult.success("/message");
        }else{
            return MzResult.failMsg(JsonConstant.ADDFAIL);
        }
    }

    @Log(title = "进入未读消息",action = BusinessType.SELECT)
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
    @Log(title = "进入公告详情",action = BusinessType.SELECT)
    public String getUnreadMsgDetail(@PathVariable("id") Integer id,Model model){
        BaseMessage unreadMsgDetail = messageService.getUnreadMsgDetail(id);
        model.addAttribute("msgDetail",unreadMsgDetail);
        BaseMessageRecord messageRecord=new BaseMessageRecord();
        String userId = CurrentUserUtil.getCurrentUser().getId();
        messageRecord.setId(userId+id);
        messageRecord.setUserId(userId);
        messageRecord.setIsRead(1);
        messageRecord.setMsgId(id);
        messageRecord.setReadTime(new Date());
        recordService.saveOrUpdate(messageRecord);
        return "message/messageDetail";
    }

    @PostMapping("/delMsgBatch")
    @ResponseBody
    public  MsgResult delMsgBatch(@RequestParam(value = "ids[]") String[] ids) {
        List<String> dictIds = Arrays.asList(ids);
        if(messageService.removeByIds(dictIds)){
            return MsgResult.successMsg(JsonConstant.DELSUCCESS);
        }
        return MsgResult.fail();
    }
}
