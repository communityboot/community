package com.muchi.community.dict.controller;


import com.muchi.community.dict.entity.BaseDictValue;
import com.muchi.community.dict.service.IBaseDictValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuzq
 * @since 2019-08-26
 */
@RestController
@RequestMapping("/dv")
public class BaseDictValueController {

    @Autowired
    private IBaseDictValueService dictValueService;

    @GetMapping("/toDictValue")
    public String toDictValue(){
        return "/admin/dictValue";
    }

    @PostMapping("/getDictVal")
    @ResponseBody
    public List<BaseDictValue> getDictValue(@RequestParam("dictId") String dictID){
        return dictValueService.getDictVallue(dictID);
    }

}
