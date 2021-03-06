package com.muchi.community.shiro.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.muchi.community.common.utils.JsonResult;
import com.muchi.community.shiro.entity.User;

import java.util.List;

/**
 * @author ChenHQ
 * @title: UserService
 * @projectName community
 * @date 2019/8/25
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param user
     * @return
     */
    JsonResult registUser(User user);


    /**
     * 分页查询 用户信息
     * @param page
     * @return
     */
    List<User> userQuery(Page page,User user);


}
