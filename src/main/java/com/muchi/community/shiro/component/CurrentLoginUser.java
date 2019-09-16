package com.muchi.community.shiro.component;

import com.muchi.community.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

/**
 * @author ChenHQ
 * @title: CurrentLoginUser
 * @projectName community
 * @description: 当前登录用户操作类
 * @date 2019/9/16
 */
@Component
public class CurrentLoginUser {

    public User getCurrentUser(){
        User userLogin = (User) SecurityUtils.getSubject().getPrincipal();
        return userLogin;
    }

}
