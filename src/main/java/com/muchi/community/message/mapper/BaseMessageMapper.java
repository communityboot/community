package com.muchi.community.message.mapper;

import com.muchi.community.message.entity.BaseMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuzq
 * @since 2019-09-07
 */
@Mapper
@Component
public interface BaseMessageMapper extends BaseMapper<BaseMessage> {

}
