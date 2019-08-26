package com.muchi.community.dict.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.dict.entity.BaseDict;
import com.muchi.community.dict.mapper.BaseDictMapper;
import com.muchi.community.dict.service.IBaseDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuzq
 * @since 2019-08-13
 */
@Service
public class BaseDictServiceImpl extends ServiceImpl<BaseDictMapper, BaseDict> implements IBaseDictService {

    @Autowired
    private BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> getAllDict(Page page) {
        return baseDictMapper.getAllDict(page);
    }

    @Override
    public Map<String, Object> delDictBatch(List<String>[] ids) {
        return null;
    }

/*    @Override
    public Map<String, Object> delDictBatch(List<String> ids) {
        int i = baseDictMapper.deleteBatchIds(ids);


    }*/


}
