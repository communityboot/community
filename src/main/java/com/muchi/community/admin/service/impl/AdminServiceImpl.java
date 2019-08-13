package com.muchi.community.admin.service.impl;

import com.muchi.community.admin.entity.Admin;
import com.muchi.community.admin.mapper.AdminMapper;
import com.muchi.community.admin.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuzq
 * @since 2019-08-13
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
