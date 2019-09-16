package com.muchi.community.shiro.shiroRealm;

import com.muchi.community.shiro.dao.PermissionDao;
import com.muchi.community.shiro.dao.RoleDao;
import com.muchi.community.shiro.dao.UserDao;
import com.muchi.community.shiro.entity.Permission;
import com.muchi.community.shiro.entity.Role;
import com.muchi.community.shiro.entity.User;
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
	private PermissionDao permissionDao;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName=(String) SecurityUtils.getSubject().getPrincipal();
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		Set<String> roles=new HashSet<String>();
		List<Role> rolesByUserName = roleDao.getRolesByUserName(userName);
		for(Role role:rolesByUserName) {
			roles.add(role.getRoleName());
		}
		List<Permission> permissionsByUserName = permissionDao.getPermissionsByUserName(userName);
		for(Permission permission:permissionsByUserName) {
			info.addStringPermission(permission.getPermissionName());
		}
		info.setRoles(roles);
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

}
