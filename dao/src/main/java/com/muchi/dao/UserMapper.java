package com.muchi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muchi.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/25   19:01
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
