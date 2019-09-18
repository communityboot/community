package com.muchi.community.shiro.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muchi.community.base.entity.User;
import com.muchi.community.common.utils.JsonResult;
import com.muchi.community.shiro.dao.UserDao;
import com.muchi.community.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author ChenHQ
 * @title: UserServiceImpl
 * @projectName community
 * @description:
 * @date 2019/8/25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     *
     * @param user
     * @return
     */
    @Override
    public JsonResult registUser(User user) {

        JsonResult result = new JsonResult();

        //通过 username 查询是否存在该用户
        User userExist = userDao.getUserByUserName(user.getUserName());
        if(userExist != null){
            result.setSuccess(false);
            result.setStatus("200");
            result.setMsg("已经存在名为：" + user.getUserName() + " 的用户");
            result.setObj(user);
            return result;
        }

        //如果不存在，则合法用户
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        user.setId(id);

        userDao.insert(user);

        //TODO:在这里设置新增的角色为普通用户角色




        result.setStatus("200");
        result.setSuccess(true);
        result.setMsg("注册成功");
        return result;
    }

    /**
     * 分页查询用户
     * @param page
     * @param user
     * @return
     */
    @Override
    public List<User> userQuery(Page page, User user) {

        List<User> users = userDao.userQuery(page, user);
        return users;
    }
}
