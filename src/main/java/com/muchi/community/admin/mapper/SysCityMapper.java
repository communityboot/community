package com.muchi.community.admin.mapper;

import com.muchi.community.admin.entity.SysCity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 城市表 Mapper 接口
 * </p>
 *
 * @author yuzq
 * @since 2019-11-19
 */
@Mapper
@Component
public interface SysCityMapper extends BaseMapper<SysCity> {

    @Select("SELECT id FROM sys_city where cityZh=#{name}")
    String getIdByCityName(@Param("name") String name);

}
