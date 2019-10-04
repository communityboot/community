package com.muchi.community.shiro.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.muchi.community.shiro.entity.SysMenu;
import com.muchi.community.user.entity.User;

import java.util.List;
import java.util.Set;

/**
 * 菜单 业务层
 * 
 */
public interface ISysMenuService extends IService<SysMenu> {
    /**
     * 根据用户ID查询菜单
     * 
     * @param user 用户信息
     * @return 菜单列表
     */
    public List<SysMenu> selectMenusByUser(User user);

    /**
     * 查询系统菜单列表
     * 
     * @param menu 菜单信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuList(SysMenu menu, String userId);


    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectPermsByUserId(String  userId);

    /**
     * 查询菜单数量
     *
     * @param parentId 菜单父ID
     * @return 结果
     */
    public int selectCountMenuByParentId(String parentId);

    /**
     * 查询菜单使用数量
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    public int selectCountRoleMenuByMenuId(String menuId);

    /**
     * 根据id删除对应菜单
     * @param menuId
     */
    public int deleteMenuById(String menuId);


}
