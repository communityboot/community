package com.muchi.community.message.service.impl;

import com.muchi.community.message.entity.BaseMessage;
import com.muchi.community.message.mapper.BaseMessageMapper;
import com.muchi.community.message.service.IBaseMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuzq
 * @since 2019-09-07
 */
@Service
public class BaseMessageServiceImpl extends ServiceImpl<BaseMessageMapper, BaseMessage> implements IBaseMessageService {

}
