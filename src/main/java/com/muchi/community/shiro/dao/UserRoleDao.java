package com.muchi.community.shiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muchi.community.shiro.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserRoleDao extends BaseMapper<UserRole> {


}
