package com.muchi.community.dict.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.dict.entity.BaseDictValue;
import com.muchi.community.dict.mapper.BaseDictValueMapper;
import com.muchi.community.dict.service.IBaseDictValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuzq
 * @since 2019-08-26
 */
@Service
public class BaseDictValueServiceImpl extends ServiceImpl<BaseDictValueMapper, BaseDictValue> implements IBaseDictValueService {

    @Autowired BaseDictValueMapper mapper;

    @Override
    public int deleteByDictIds(String[] ids) {
        return  mapper.deleteByDictIds(ids);
    }

    /**
     * 根据字典id去字典值表查找字典值列表
     * @param  dictId 字典id
     * @return List<BaseDictValue>
     */
    public List<BaseDictValue> getDictVallue(Page page,String dictId){
        return mapper.getDictValues(page,dictId);
    }
}
