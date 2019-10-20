package com.muchi.community.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.muchi.community.shiro.entity.SchoolProject;

/**
 * @author ChenHQ
 * @title: SchoolProjectService
 * @projectName community
 * @date 2019/10/20
 */
public interface SchoolProjectService extends IService<SchoolProject> {

    /**
     * 用户上传信息的保存
     */
    void saveSchoolProject(SchoolProject schoolProject);


}
