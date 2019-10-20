package com.muchi.community.shiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muchi.community.shiro.entity.SchoolProject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author ChenHQ
 * @title: SchoolProjectDao
 * @projectName community
 * @date 2019/10/20
 */
@Mapper
@Component
public interface SchoolProjectDao  extends BaseMapper<SchoolProject> {


}
