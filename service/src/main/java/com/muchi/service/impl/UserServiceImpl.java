package com.muchi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muchi.dao.UserMapper;
import com.muchi.entity.User;
import com.muchi.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/25   19:04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService {
}
