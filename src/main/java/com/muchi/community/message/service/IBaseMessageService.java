package com.muchi.community.message.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.message.entity.BaseMessage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzq
 * @since 2019-09-07
 */
public interface IBaseMessageService extends IService<BaseMessage> {

    List<BaseMessage> getAllDict(Page page);

    List<String> getMessageIds();

    Integer getUnReadMessageNum();

    List<BaseMessage> getUnreadMsg();

    BaseMessage getUnreadMsgDetail(Integer id);

    IPage<BaseMessage> searchMsg(Page<BaseMessage> page, QueryWrapper<BaseMessage> wrapper);
}
