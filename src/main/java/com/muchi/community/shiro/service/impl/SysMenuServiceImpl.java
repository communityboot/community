package com.muchi.community.shiro.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muchi.community.shiro.dao.SysMenuDao;
import com.muchi.community.shiro.entity.SysMenu;
import com.muchi.community.shiro.service.ISysMenuService;
import com.muchi.community.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 菜单
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements ISysMenuService {

    public static final String PREMISSION_STRING = "perms[\"{0}\"]";

    @Autowired
    private SysMenuDao SysMenuDao;

    /**
     * 根据用户查询菜单
     *
     * @param user 用户信息
     * @return 菜单列表
     */
    @Override
    public List<SysMenu> selectMenusByUser(User user) {
        List<SysMenu> menus = new LinkedList<SysMenu>();
        // 管理员显示所有菜单信息
        if (user.isAdmin()) {
            menus = SysMenuDao.selectMenuNormalAll();
        } else {
            menus = SysMenuDao.selectMenusByUserId(user.getId());
        }
        return getChildPerms(menus, 0);
    }

    /**
     * 查询菜单集合
     *
     * @return 所有菜单信息
     */
    @Override
    public List<SysMenu> selectMenuList(SysMenu menu, String userId) {
        List<SysMenu> menuList = null;
        if (User.isAdmin(userId)) {
            menuList = SysMenuDao.selectMenuList(menu);
        } else {
            menu.getParams().put("userId", userId);
            menuList = SysMenuDao.selectMenuListByUserId(menu);
        }
        return menuList;
    }


    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectPermsByUserId(String userId) {
        List<String> perms = SysMenuDao.selectPermsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (!StringUtils.isEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }


    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list     分类表
     * @param parentId 传入的父节点ID
     * @return String4
     */
    public List<SysMenu> getChildPerms(List<SysMenu> list, int parentId) {
        List<SysMenu> returnList = new ArrayList<SysMenu>();
        for (Iterator<SysMenu> iterator = list.iterator(); iterator.hasNext(); ) {
            SysMenu t = (SysMenu) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == parentId) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }


    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private void recursionFn(List<SysMenu> list, SysMenu t) {
        // 得到子节点列表
        List<SysMenu> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysMenu tChild : childList) {
            if (hasChild(list, tChild)) {
                // 判断是否有子节点
                Iterator<SysMenu> it = childList.iterator();
                while (it.hasNext()) {
                    SysMenu n = (SysMenu) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<SysMenu> getChildList(List<SysMenu> list, SysMenu t) {
        List<SysMenu> tlist = new ArrayList<SysMenu>();
        Iterator<SysMenu> it = list.iterator();
        while (it.hasNext()) {
            SysMenu n = (SysMenu) it.next();
            if (n.getParentId().longValue() == t.getMenuId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SysMenu> list, SysMenu t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }


    /**
     * 查询菜单数量
     *
     * @param parentId 菜单父ID
     * @return
     */
    @Override
    public int selectCountMenuByParentId(String parentId) {
        return SysMenuDao.selectCountMenuByParentId(parentId);
    }

    /**
     * 查询菜单使用数量
     *
     * @param menuId 菜单ID
     * @return
     */
    @Override
    public int selectCountRoleMenuByMenuId(String menuId) {
        return SysMenuDao.selectCountRoleMenuByMenuId(menuId);
    }


    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    @Override
    public int deleteMenuById(String menuId) {
        return SysMenuDao.deleteMenuById(menuId);
    }

    /**
     * 更新菜单信息
     * @param sysMenu
     * @return
     */
    @Override
    public int updateMenu(SysMenu sysMenu) {

        //如果菜单id为空，即为添加
        if(sysMenu.getMenuId() == null){
            //设置的菜单id为自增模式，所以不需要设置
            SysMenuDao.insert(sysMenu);
        }else{
            //否则为更新操作
            SysMenuDao.updateById(sysMenu);
        }
        return 0;
    }



}
