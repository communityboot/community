package com.muchi.community.shiro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.muchi.community.user.entity.User;
import com.muchi.community.common.utils.JsonResult;

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
    IPage<User> userQuery(Page<User> page, QueryWrapper<User> wrapper);

}
