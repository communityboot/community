package com.muchi.community.base.service.impl;

import com.muchi.community.base.entity.User;
import com.muchi.community.base.mapper.SysUserMapper;
import com.muchi.community.base.service.SysIUserService;
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
