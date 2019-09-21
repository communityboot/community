package com.muchi.community.shiro.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.utils.LayuiVo;
import com.muchi.community.common.utils.ShiroUtils;
import com.muchi.community.dict.controller.BaseDictController;
import com.muchi.community.dict.entity.BaseDict;
import com.muchi.community.dict.service.IBaseDictService;
import com.muchi.community.dict.service.IBaseDictValueService;
import com.muchi.community.shiro.entity.SysMenu;
import com.muchi.community.shiro.service.ISysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ChenHQ
 * @title: MenuController
 * @projectName community
 * @description: 菜单管理
 * @date 2019/9/21
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    private static Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private ISysMenuService menuService;


    /**
     * 菜单首页
     * @return
     */
    @RequestMapping("/toMenuPage")
    public String toMenuPage() {
        return "admin/menu";
    }

    //暂时放开对应权限
    //@RequiresPermissions("system:menu:list")
    @GetMapping("/list")
    @ResponseBody
    public LayuiVo list(SysMenu menu)
    {
        String userId = ShiroUtils.getUserId();
        List<SysMenu> menuList = menuService.selectMenuList(menu, userId);
        return LayuiVo.successLayui(0L,menuList);
    }



}
