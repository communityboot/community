package com.muchi.community.dict.controller;


import com.muchi.community.common.constant.JsonConstant;
import com.muchi.community.dict.entity.BaseDictValue;
import com.muchi.community.dict.service.IBaseDictValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/toDictValue")
    public Map<String,String> toDictValue(){
        Map<String,String> map=new HashMap<>();
        map.put(JsonConstant.RESULT, JsonConstant.SUCCESS);
        return map;
    }

    @RequestMapping("/dictPage")
    public String toDictValPage(){
        return "admin/dictValue";
    }

    @PostMapping("/getDictVal")
    @ResponseBody
    public List<BaseDictValue> getDictValue(@RequestParam("dictId") String dictID){
        return dictValueService.getDictVallue(dictID);
    }

}
