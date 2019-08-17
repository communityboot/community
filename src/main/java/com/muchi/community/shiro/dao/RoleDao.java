package com.muchi.community.shiro.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muchi.community.shiro.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleDao extends BaseMapper<Role> {

	/**
	 *  通过用户名获取角色信息
	 * @param userName
	 * @return
	 */
	List<Role> getRolesByUserName(String userName);

}
