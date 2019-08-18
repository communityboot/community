package com.muchi.community.shiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muchi.community.shiro.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserRoleDao extends BaseMapper<UserRole> {

    /**
     * 通过用户名获取所有用户关联角色
     * @param username
     * @return
     */
    List<UserRole> getUserRoleByUserName(String username);

}
