package com.muchi.community.dict.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.dict.entity.BaseDictValue;
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
 * @since 2019-08-26
 */
@Mapper
@Component
public interface BaseDictValueMapper extends BaseMapper<BaseDictValue> {

    int deleteByDictIds(String[] ids);

    @Select("select * from base_dict_value where dict_id = #{dictId}")
    List<BaseDictValue> getDictValues(Page page, @Param("dictId") String dictId);


    @Select("SELECT  dv.dict_key, dv.dict_val, d.dictLabel FROM base_dict_value dv LEFT JOIN base_dict d on dv.dict_id = d.id WHERE d.dictLabel = #{dictCode}")
    List<BaseDictValue> getDictByCode(@Param("dictCode") String dictCode);



}
