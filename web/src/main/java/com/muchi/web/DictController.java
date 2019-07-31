package com.muchi.web;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.community.layui.LayUiVo;
import com.google.common.collect.Maps;
import com.muchi.entity.Dict;
import com.muchi.service.DictService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/29   21:55
 */
@Controller
public class DictController {

    @Autowired
    private DictService dictService;

/*    @RequestMapping("/getAllDict")
    @ResponseBody
    public LayUiVo getAllDict(Page page, @RequestParam("limit")int limit){
        page.setSize(limit);
        IPage<Dict> dictIPage = dictService.selectDictVo(page);
        LayUiVo layUiVo=new LayUiVo();
        layUiVo.setCode(0);
        layUiVo.setMsg("成功");
        layUiVo.setData(dictIPage);
        return layUiVo;
    }*/
    @RequestMapping("/getAllDict")
    @ResponseBody
    public LayUiVo getAllDict(Page page, @RequestParam("limit")int limit,@RequestParam(value = "page",defaultValue = "1")int page1){
        page.setSize(limit);
        page.setCurrent(page1);
        List<Dict> allDict = dictService.getAllDict(page);
        LayUiVo layUiVo=new LayUiVo();
        layUiVo.setCode(0);
        layUiVo.setMsg("成功");
        layUiVo.setData(allDict);
        layUiVo.setCount(page.getTotal());
    return layUiVo;
    }

    @RequestMapping("toDictpage")
    public String toDictPage(){
        return "dictManage";
    }

    @PostMapping("/delDictById")
    @ResponseBody
    public Map<String,String> delDictById(@Param("id")Integer id){
        Map<String,String> map= Maps.newHashMap();
        boolean b = dictService.removeById(id);
        if(b){
            map.put("result","删除成功");
        }else {
            map.put("result","删除失败");
        }
        return map;
    }

    @RequestMapping("/updateDict")
    @ResponseBody
    public Dict updateDict(Model model,Dict dict){
        Dict dictInfo =new Dict();
        if(dict!=null){
            boolean b = dictService.saveOrUpdate(dict);
            dictInfo= dictService.getById(dict.getId());
        }
        model.addAttribute("dict",dictInfo);
        return dictInfo;
    }

    @RequestMapping("/getDictInfo")
    @ResponseBody
    public Map<String,Object> getDictInfo(@Param("id")Integer id){
        Dict dictInfo=new Dict();
        Map<String,Object> map=Maps.newHashMap();
        if(id!=null){
            dictInfo = dictService.getById(id);
           map.put("result","成功");
           map.put("dict",dictInfo);
        }
        return map;
    }
}
