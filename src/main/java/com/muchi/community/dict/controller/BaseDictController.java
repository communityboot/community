package com.muchi.community.dict.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.LayuiVo;
import com.muchi.community.dict.entity.BaseDict;
import com.muchi.community.dict.service.IBaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuzq
 * @since 2019-08-13
 */
@Controller
@RequestMapping("/dict")
public class BaseDictController {

    @Autowired
   private IBaseDictService dictService;

    @RequestMapping("/toDictPage")
    public String toDictPage(){
        return "admin/dict";
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public LayuiVo getAll(Page page, @RequestParam("limit")int limit, @RequestParam(value = "page",defaultValue = "1")int currentPage){
        page.setSize(limit);
        page.setCurrent(currentPage);
        List<BaseDict> list = dictService.getAllDict(page);
        LayuiVo layUiVo=new LayuiVo();
        layUiVo.setCode(0);
        layUiVo.setMsg("成功");
        layUiVo.setCount(page.getTotal());
        layUiVo.setData(list);
        return layUiVo;
    }

}
