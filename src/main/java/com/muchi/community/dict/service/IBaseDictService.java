package com.muchi.community.dict.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.dict.entity.BaseDict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.muchi.community.dict.vo.DictVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzq
 * @since 2019-08-13
 */
public interface IBaseDictService extends IService<BaseDict> {

    List<BaseDict> getAllDict(Page page);

    IPage<BaseDict> getAllDictTest(Page<BaseDict> page, QueryWrapper<BaseDict> wrapper);

    int delDictBatch(String[] ids);

    List<DictVo> getDictByType(String dictLabel);




}
