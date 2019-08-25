package com.muchi.community.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.muchi.community.common.utils.JsonResult;
import com.muchi.community.shiro.entity.User;

/**
 * @author ChenHQ
 * @title: UserService
 * @projectName community
 * @date 2019/8/25
 */
public interface UserService extends IService<User> {

    JsonResult registUser(User user);


}
