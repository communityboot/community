package com.muchi.community.dict.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.dict.entity.BaseDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

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
public interface BaseDictMapper extends BaseMapper<BaseDict> {

    List<BaseDict> getAllDict(Page page);

}
