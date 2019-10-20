package com.muchi.community.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muchi.community.shiro.dao.SchoolProjectDao;
import com.muchi.community.shiro.entity.SchoolProject;
import com.muchi.community.shiro.service.SchoolProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenHQ
 * @title: SchoolProjectServiceImpl
 * @projectName community
 * @description: TODO
 * @date 2019/10/20
 */
@Service
public class SchoolProjectServiceImpl extends ServiceImpl<SchoolProjectDao, SchoolProject> implements SchoolProjectService {


    @Autowired
    private SchoolProjectDao projectDao;

    /**
     * 保存用户上传
     * @param schoolProject
     */
    @Override
    public void saveSchoolProject(SchoolProject schoolProject) {
        projectDao.insert(schoolProject);
    }
}
