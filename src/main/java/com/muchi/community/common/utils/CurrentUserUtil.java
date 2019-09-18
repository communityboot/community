package com.muchi.community.common.utils;

import com.muchi.community.user.entity.User;
import org.apache.shiro.SecurityUtils;

/**
 * @Author： yuzq
 * @Description: 获取当前用户信息
 * @Date: 2019/9/18   15:19
 */
public class CurrentUserUtil {
    /**
     * @return 获取当前用户信息
     */
    public static User getCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user!=null){
            return user;
        }return new User();
    }
}
