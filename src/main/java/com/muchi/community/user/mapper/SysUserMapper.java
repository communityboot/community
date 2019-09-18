package com.muchi.community.user.mapper;

import com.muchi.community.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuzq
 * @since 2019-09-17
 */
@Component
@Mapper
public interface SysUserMapper extends BaseMapper<User> {

}
