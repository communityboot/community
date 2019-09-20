package com.muchi.community.user.service;

import com.muchi.community.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzq
 * @since 2019-09-17
 */
public interface SysIUserService extends IService<User> {

    User getUserInfoById(String id);

}
