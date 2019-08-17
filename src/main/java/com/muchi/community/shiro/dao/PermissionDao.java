package com.muchi.community.shiro.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muchi.community.shiro.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PermissionDao extends BaseMapper<Permission> {

	/**
	 * 通过用户名获取权限集合
	 * @param userName
	 * @return
	 */
	List<Permission> getPermissionsByUserName(String userName);

}
