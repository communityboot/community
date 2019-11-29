package com.muchi.community.user.controller;


import com.muchi.community.common.constant.BusinessType;
import com.muchi.community.common.constant.JsonConstant;
import com.muchi.community.common.log.Log;
import com.muchi.community.common.utils.CurrentUserUtil;
import com.muchi.community.common.utils.MzResult;
import com.muchi.community.user.entity.User;
import com.muchi.community.user.service.SysIUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuzq
 * @since 2019-09-17
 */
@Controller
@CrossOrigin
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysIUserService userService;

    @RequestMapping("/getUserInfoById")
    @Log(title = "用户查看信息",action = BusinessType.SELECT)
    public String getUserInfoById(Model model){
        User currentUser = CurrentUserUtil.getCurrentUser();
        User userInfo = userService.getUserInfoById(currentUser.getId());
        if(userInfo!=null){
            model.addAttribute("userInfo",userInfo);
            return "admin/userInfo";
        }return "error";
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public MzResult getUserById(@RequestBody String id){
    if(!id.equals("")){
        User userInfoById = userService.getUserInfoById(id);
        userInfoById.setPassword("");
        return MzResult.success(userInfoById);
        }
    return MzResult.failMsg(JsonConstant.ILLEGAL_ARGUMENT);
    }

    @RequestMapping("/startConversation")
    public String startConversation(){
        return "commons/socketClient";
    }

    @RequestMapping("/robotConversation")
    public String robotConversation(){
        return "commons/robotClient";
    }
}
