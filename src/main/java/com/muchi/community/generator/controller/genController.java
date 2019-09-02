package com.muchi.community.generator.controller;

import com.muchi.community.generator.entity.TableInfo;
import com.muchi.community.generator.service.GenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/9/2   15:46
 */
@Controller
@RequestMapping("/gen")
public class genController {

    @Autowired
    private GenService genService;

    @RequestMapping("/getTable")
    public List<TableInfo>  getTable(){
        return genService.genTable();
    }

}
