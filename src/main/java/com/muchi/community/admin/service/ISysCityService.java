package com.muchi.community.admin.service;

import com.muchi.community.admin.entity.SysCity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 城市表 服务类
 * </p>
 *
 * @author yuzq
 * @since 2019-11-19
 */
public interface ISysCityService extends IService<SysCity> {

    String getIdByCityName(String name);

}
