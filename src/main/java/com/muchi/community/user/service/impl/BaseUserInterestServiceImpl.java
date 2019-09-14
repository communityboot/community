package com.muchi.community.user.service.impl;

import com.muchi.community.user.entity.BaseUserInterest;
import com.muchi.community.user.mapper.BaseUserInterestMapper;
import com.muchi.community.user.service.IBaseUserInterestService;
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
 * @since 2019-09-14
 */
@Service
public class BaseUserInterestServiceImpl extends ServiceImpl<BaseUserInterestMapper, BaseUserInterest> implements IBaseUserInterestService {


    @Autowired
    private BaseUserInterestMapper interestMapper;

    @Override
    public List<Map<String,String>> getUserIdsByInterest() {
        return interestMapper.getUserIdsByInterest();
    }

    @Override
    public List<String> testParam(String name) {
        return interestMapper.testParam(name);
    }

    @Override
    public List<String> queryIdsByInterest(String ids) {
        return interestMapper.queryIdsByInterest(ids);
    }
}
