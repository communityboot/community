package com.muchi.community.base.mapper;

import com.muchi.community.base.entity.User;
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
