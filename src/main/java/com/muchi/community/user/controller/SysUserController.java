package com.muchi.community.user.controller;


import com.muchi.community.common.constant.BusinessType;
import com.muchi.community.common.log.Log;
import com.muchi.community.common.utils.CurrentUserUtil;
import com.muchi.community.user.entity.User;
import com.muchi.community.user.service.SysIUserService;
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
 * @since 2019-09-17
 */
@Controller
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
}
