package com.muchi.community.admin.mapper;

import com.muchi.community.admin.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuzq
 * @since 2019-08-13
 */
@Mapper
@Component
public interface AdminMapper extends BaseMapper<Admin> {

}
