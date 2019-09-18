package com.muchi.community.user.service.impl;

import com.muchi.community.user.entity.User;
import com.muchi.community.user.mapper.SysUserMapper;
import com.muchi.community.user.service.SysIUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuzq
 * @since 2019-09-17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, User> implements SysIUserService {

}
