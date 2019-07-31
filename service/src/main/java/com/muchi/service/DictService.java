package com.muchi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.muchi.entity.Dict;

import java.util.List;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/29   21:21
 */
public interface DictService extends IService<Dict> {

    IPage<Dict> selectDictVo(Page page);

    List<Dict> getAllDict(Page page);

}
