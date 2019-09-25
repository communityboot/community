package com.muchi.community.quartz.mapper;

import com.muchi.community.quartz.entity.SysQrtzCron;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuzq
 * @since 2019-09-25
 */
@Mapper
@Component
public interface SysQrtzCronMapper extends BaseMapper<SysQrtzCron> {

}
