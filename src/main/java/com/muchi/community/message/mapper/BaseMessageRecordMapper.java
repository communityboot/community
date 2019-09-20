package com.muchi.community.message.mapper;

import com.muchi.community.message.entity.BaseMessageRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

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
public interface BaseMessageRecordMapper extends BaseMapper<BaseMessageRecord> {

    @Select("select msgId from base_message_record where userId=#{userId}")
    List<String> getUnreadIds(@Param("userId") String userId);

}
