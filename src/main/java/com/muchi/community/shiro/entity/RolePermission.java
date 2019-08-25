package com.muchi.community.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * shiro 角色权限类
 */
@TableName("t_role_permission")
public class RolePermission {

	private String id; // 编号

	private Role role; // 角色

	private Permission menu; // 菜单

	private String remarks; // 备注

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getMenu() {
		return menu;
	}

	public void setMenu(Permission menu) {
		this.menu = menu;
	}

	public RolePermission() {
		super();
	}

}
