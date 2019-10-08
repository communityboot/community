package com.muchi.community.admin.controller;

import com.muchi.community.admin.service.IAdminService;
import com.muchi.community.common.log.Log;
import com.muchi.community.common.utils.CurrentUserUtil;
import com.muchi.community.common.utils.MzResult;
import com.muchi.community.message.service.IBaseMessageService;
import com.muchi.community.shiro.service.UserService;
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
    private UserService userService;

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
        String userName = CurrentUserUtil.getCurrentUser().getUserName();
        String avatarUrl = userService.getById(CurrentUserUtil.getCurrentUser().getId()).getHeadPicUrl();
        if(avatarUrl==null){
            //todo 这个需要上传几个默认的图片头像地址，避免空指针
            avatarUrl="";
        }
        model.addAttribute("UnReadNum",unReadMessageNum);
        model.addAttribute("userName",userName);
        model.addAttribute("avatarUrl",avatarUrl);
        return "commons/Frame";
    }


}
