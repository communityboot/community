package com.muchi.community.message.service.impl;

import com.muchi.community.message.entity.BaseMessageRecord;
import com.muchi.community.message.mapper.BaseMessageRecordMapper;
import com.muchi.community.message.service.IBaseMessageRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuzq
 * @since 2019-09-07
 */
@Service
public class BaseMessageRecordServiceImpl extends ServiceImpl<BaseMessageRecordMapper, BaseMessageRecord> implements IBaseMessageRecordService {

    @Autowired
    private BaseMessageRecordMapper recordMapper;

    @Override
    public List<Integer> getUnreadIds(Integer userId) {
        return recordMapper.getUnreadIds(userId);
    }
}
