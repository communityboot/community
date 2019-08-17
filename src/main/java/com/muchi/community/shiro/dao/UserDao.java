package com.muchi.community.shiro.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muchi.community.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface UserDao extends BaseMapper<User> {
	
	/**
	 * 登录的时候，根据用户名获取用户实体
	 * @param userName
	 * @return
	 */
	 User getUserByUserName(String userName);
}
