package com.muchi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/29   21:20
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict>{

    IPage<Dict> selectDictVo(Page page);

    List<Dict> getAllDict(Page page);
}
