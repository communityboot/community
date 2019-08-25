package com.muchi.community.common.utils;

import java.util.UUID;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/8/25   14:48
 */
public class UUIDUtil {

    /**
     * 生成UUID
     * @return UUID
     */
    public static String genUUID(){
      return   UUID.randomUUID().toString().replaceAll("-", "");
    }
}
