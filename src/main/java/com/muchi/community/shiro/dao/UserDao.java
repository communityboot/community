package com.muchi.community.shiro.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface UserDao extends BaseMapper<User> {
	
	/**
	 * 登录的时候，根据用户名获取用户实体
	 * @param userName
	 * @return
	 */
	 User getUserByUserName(String userName);


	/**
	 * 分页查询用户
	 * @param page
	 * @param user
	 * @return
	 */
	 List<User> userQuery(Page page, User user);


}
