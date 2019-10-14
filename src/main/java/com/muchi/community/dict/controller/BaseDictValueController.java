package com.muchi.community.dict.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.constant.JsonConstant;
import com.muchi.community.common.utils.LayuiVo;
import com.muchi.community.common.utils.MzResult;
import com.muchi.community.common.utils.UUIDUtil;
import com.muchi.community.dict.entity.BaseDictValue;
import com.muchi.community.dict.service.IBaseDictValueService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuzq
 * @since 2019-08-26
 */
@RequestMapping("/dv")
@Controller
public class BaseDictValueController {

    @Autowired
    private IBaseDictValueService dictValueService;

    @RequestMapping("/toDvPage/{id}")
    public String toDvPage(@PathVariable("id") String id, Model model){
        model.addAttribute("dictId",id);
        return "admin/dictValue";
    }

    @RequestMapping("/toDictValue")
    public Map<String,String> toDictValue(){
        Map<String,String> map=new HashMap<>();
        map.put(JsonConstant.RESULT, JsonConstant.SUCCESS);
        return map;
    }

    @RequestMapping("/dictPage")
    public Map<String,String> toDictValPage(@RequestParam("dictId")String dictId, Model model){
        Map<String ,String> map=new HashMap<>();
        map.put(JsonConstant.RESULT, JsonConstant.SUCCESS);
        model.addAttribute("dictId",dictId);
        return map;
    }

    @RequestMapping("/getDictVal/{dId}")
    @RequiresPermissions("system:dictvalue:view")
    @ResponseBody
    public LayuiVo getDictValue(Page page, @RequestParam("limit") int limit, @RequestParam(value = "page", defaultValue = "1") int currentPage,@PathVariable("dId") String dictID){
        page.setSize(limit);
        page.setCurrent(currentPage);
        List<BaseDictValue> dictValue = dictValueService.getDictValue(page, dictID);
        return LayuiVo.successLayui(page.getTotal(),dictValue);

    }

    @PostMapping("/updateDict")
    @ResponseBody
    public LayuiVo updateDictValue(@RequestBody BaseDictValue baseDictValue){
        if (baseDictValue != null) {
            if(baseDictValue.getId().equals("")){
                baseDictValue.setId(UUIDUtil.genUUID());
            }
            boolean b = dictValueService.saveOrUpdate(baseDictValue);
            if(b){
               return LayuiVo.successCustomMsg(JsonConstant.SUCCESS);
            }
        }
        return LayuiVo.failCustomMsg(JsonConstant.UPDATEFAIL);
    }

    @PostMapping("/delDictValBatch")
    @ResponseBody
    public  LayuiVo delDictValBatch(@RequestParam(value = "ids[]") String[] ids) {
        List<String> dictIds = Arrays.asList(ids);
        if(dictValueService.removeByIds(dictIds)){
            return LayuiVo.successCustomMsg(JsonConstant.SUCCESS);
            }
        return LayuiVo.failCustomMsg(JsonConstant.DELFAIL);
    }


    @PostMapping("/getDictByCode")
    @ResponseBody
    public  LayuiVo getDictByCode(String dicCode) {
        List<BaseDictValue> dictByCode = dictValueService.getDictByCode(dicCode);
        return LayuiVo.successByData(0L,dictByCode);
    }

    @PostMapping("/getDictValById")
    @ResponseBody
    public MzResult getDictValById(@RequestBody String dictValId){
        BaseDictValue dictValById = dictValueService.getDictValById(dictValId);
        if(dictValById!=null){
            return MzResult.success(dictValById);
        }return MzResult.failMsg(JsonConstant.ILLEGAL_ARGUMENT);
    }
}
