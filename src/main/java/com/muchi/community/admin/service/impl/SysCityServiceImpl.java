package com.muchi.community.admin.service.impl;

import com.muchi.community.admin.entity.SysCity;
import com.muchi.community.admin.mapper.SysCityMapper;
import com.muchi.community.admin.service.ISysCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 城市表 服务实现类
 * </p>
 *
 * @author yuzq
 * @since 2019-11-19
 */
@Service
public class SysCityServiceImpl extends ServiceImpl<SysCityMapper, SysCity> implements ISysCityService {

    @Autowired
    private SysCityMapper cityMapper;

    @Override
    public String getIdByCityName(String name) {
        return cityMapper.getIdByCityName(name);
    }
}
