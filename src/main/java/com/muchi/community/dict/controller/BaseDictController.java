package com.muchi.community.dict.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.LayuiVo;
import com.muchi.community.dict.entity.BaseDict;
import com.muchi.community.dict.service.IBaseDictService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private static Logger logger= LoggerFactory.getLogger(BaseDictController.class);

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

    @RequestMapping("/getDictInfo")
    @ResponseBody
    public Map<String,Object> updateDict(@Param("id")Integer id){
        BaseDict dictInfo=new BaseDict();
        Map<String,Object> map=new HashMap<>();
        if(id!=null){
            dictInfo=dictService.getById(id);
            map.put("result","000");
            map.put("dict",dictInfo);
        }
        return map;
    }

    @PostMapping("/updateDict")
    @ResponseBody
    public Map<String,String> updateDict(@RequestBody BaseDict dict){
        Map<String,String> map=new HashMap<>();
        if(dict !=null){
            try {
                boolean b = dictService.saveOrUpdate(dict);
                if(b){
                    map.put("result","000");
                }else {
                    map.put("result","111");
                }
            }catch (Exception e){
                logger.info("更新字典失败,字典id为："+dict.getId());
            }
        }
        return map;
    }

}
