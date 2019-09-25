package com.muchi.community.shiro.controller;

import com.muchi.community.common.utils.LayuiVo;
import com.muchi.community.shiro.entity.SysMenu;
import com.muchi.community.shiro.service.ISysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
     *
     * @return 菜单首页
     */
    @RequestMapping("/toMenuPage")
    public String toMenuPage() {
        return "admin/menu";
    }

    //暂时放开对应权限
    //@RequiresPermissions("system:menu:list")
    @GetMapping("/list")
    @ResponseBody
    public LayuiVo list(SysMenu menu) {
        //String userId = ShiroUtils.getUserId();
        String userId = "1";
        List<SysMenu> menuList = menuService.selectMenuList(menu, userId);

        //将菜单封装成指定格式
        //List<SysMenu> sysMenus = parseTree(menuList);

        return LayuiVo.successLayui(0L, menuList);
    }


    /**
     * @param menuList 菜单列表
     * @return  解析树状结构数据，返回指定正确格式的json
     */
    public List<SysMenu> parseTree(List<SysMenu> menuList) {

        List<SysMenu> listParent = new ArrayList();//表示父菜单

        Map<Long, SysMenu> map = new HashMap();//这个map是为了让儿子通过id和pid的关系找到父级的

        for (SysMenu menu : menuList) {
            map.put(menu.getMenuId(), menu);
        }

        for (SysMenu menu : menuList) {
            if (menu.getParentId() == 0) {//最顶级的父菜单
                listParent.add(menu);
            } else { //儿子，还需要通过儿子去找到父亲
                SysMenu parent = map.get(menu.getParentId());//通过儿子的pid找到它父亲
                parent.getChildren().add(menu);
            }
        }

            return listParent;
        }


    }
