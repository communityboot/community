package com.muchi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muchi.entity.Admin;
import com.muchi.dao.AdminMapper;
import com.muchi.service.IAdminService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuzq
 * @since 2019-07-31
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
