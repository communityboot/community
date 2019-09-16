package com.muchi.community.message.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.log.Log;
import com.muchi.community.common.utils.IpUtils;
import com.muchi.community.common.utils.LayuiVo;
import com.muchi.community.common.utils.MsgResult;
import com.muchi.community.common.utils.MzResult;
import com.muchi.community.message.entity.BaseMessage;
import com.muchi.community.message.service.IBaseMessageRecordService;
import com.muchi.community.message.service.IBaseMessageService;
import com.muchi.community.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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

    @Log(title = "查询未读公告")
    @RequestMapping("/getUnReadMessageNum")
    @ResponseBody
    public MzResult getUnReadMessageNum(){
        List<Integer> messageIds = messageService.getMessageIds();
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user !=null){
            //对已读的记录进行去重
            List<Integer> unreadIds = recordService.getUnreadIds(Integer.parseInt(user.getId()));
            HashSet<Integer> h1=new HashSet<>(messageIds);
            HashSet<Integer> h2=new HashSet<>(unreadIds);
            h1.removeAll(h2);
            messageIds.clear();
            messageIds.addAll(h1);
            Map<String ,Object> map=new HashMap<>();
            map.put("unReadNum",h1.size());
            map.put("unReadIds",h1);
            return MzResult.success(map);
        }
        return MzResult.fail();
    }

}
