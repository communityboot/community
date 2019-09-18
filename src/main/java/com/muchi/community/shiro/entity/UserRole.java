package com.muchi.community.shiro.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.muchi.community.user.entity.User;

/**
 * shiro 权限 用户角色
 */
@TableName("sys_user_role")
public class UserRole {

	private String id; // 编号

	private User user; // 用户

	private Role role; // 角色

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRole() {
		super();
	}

}
