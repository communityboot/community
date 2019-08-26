package com.muchi.community.dict.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.dict.entity.BaseDict;
import com.baomidou.mybatisplus.extension.service.IService;

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

    int delDictBatch(String[] ids);

}
