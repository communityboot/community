package com.muchi.community.shiro.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muchi.community.shiro.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RolePermissionDao extends BaseMapper<RolePermission> {

    /**
     * 通过用户名获取所有角色权限
     * @param username
     * @return
     */
    List<RolePermission> getRolePermissionByUsername(String username);

}
