package com.muchi.community.dict.mapper;

import com.muchi.community.dict.entity.BaseDictValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuzq
 * @since 2019-08-26
 */
@Mapper
@Component
public interface BaseDictValueMapper extends BaseMapper<BaseDictValue> {

}
