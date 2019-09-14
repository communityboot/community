package com.muchi.community.user.service;

import com.muchi.community.user.entity.BaseUserInterest;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzq
 * @since 2019-09-14
 */
public interface IBaseUserInterestService extends IService<BaseUserInterest> {

    List<Map<String,String>> getUserIdsByInterest();

    List<String> testParam(String name);
    List<String> queryIdsByInterest(String ids);
}
