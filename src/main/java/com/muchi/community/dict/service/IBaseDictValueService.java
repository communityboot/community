package com.muchi.community.dict.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.dict.entity.BaseDictValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzq
 * @since 2019-08-26
 */
public interface IBaseDictValueService extends IService<BaseDictValue> {

    int deleteByDictIds(String[] ids);

    List<BaseDictValue> getDictValue(Page page,String dictId);


    /**
     * 通过字典代号获取字典下面的键值
     * @param dicCode
     * @return
     */
    List<BaseDictValue> getDictByCode(String dicCode);

    BaseDictValue getDictValById(String id);


}
