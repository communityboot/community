package com.muchi.community.message.service;

import com.muchi.community.message.entity.BaseMessageRecord;
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
public interface IBaseMessageRecordService extends IService<BaseMessageRecord> {

    List<Integer> getUnreadIds(Integer userId);

}
