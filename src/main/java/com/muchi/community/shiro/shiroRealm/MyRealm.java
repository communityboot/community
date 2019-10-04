package com.muchi.community.shiro.shiroRealm;

import com.muchi.community.common.utils.ShiroUtils;
import com.muchi.community.shiro.service.ISysMenuService;
import com.muchi.community.user.entity.User;
import com.muchi.community.shiro.dao.RoleDao;
import com.muchi.community.shiro.dao.UserDao;
import com.muchi.community.shiro.entity.Role;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义 Realm
 */
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;


	@Autowired
	private ISysMenuService menuService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		User user = ShiroUtils.getUser();
		// 角色列表
		Set<String> roles = new HashSet<String>();
		// 功能列表
		Set<String> menus = new HashSet<String>();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 管理员拥有所有权限
		if (user.isAdmin())
		{
			info.addRole("admin");
			info.addStringPermission("*:*:*");
		}
		else
		{
			//TODO: 需要导入的是service层
			List<Role> rolesByUserName = roleDao.getRolesByUserName(user.getUserName());
			for(Role role:rolesByUserName) {
				roles.add(role.getRoleName());
			}


			//menus = menuService.selectPermsByUserId(user.getId());
			//普通用户模拟菜单
			menus.add("system:dict:view");

			// 角色加入AuthorizationInfo认证对象
			info.setRoles(roles);
			// 权限加入AuthorizationInfo认证对象
			info.setStringPermissions(menus);
		}

		return info;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = token.getPrincipal().toString();
		User user = userDao.getUserByUserName(userName);
		if (user != null) {

			User userLogin = new User();
			userLogin.setUserName(userName);
			userLogin.setId(user.getId());

			// Object principal, Object credentials, String realmName
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userLogin, user.getPassword(), getName());
			return authcInfo;
		} else {
			return null;
		}
	}

	/**
	 * 清理缓存权限
	 */
	public void clearCachedAuthorizationInfo()
	{
		this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
	}

}
