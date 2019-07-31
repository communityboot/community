package com.muchi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muchi.dao.DictMapper;
import com.muchi.entity.Dict;
import com.muchi.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/29   21:22
 */
@Service
@Transactional
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public IPage<Dict> selectDictVo(Page page) {

        return dictMapper.selectDictVo(page);
    }

    @Override
    public List<Dict> getAllDict(Page page) {
        return dictMapper.getAllDict(page);
    }
}
