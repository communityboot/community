package com.muchi.community.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * shiro 权限类
 */
@TableName("sys_permission")
public class Permission {

	private String id; // 编号

	@TableField("permission_name")
	private String permissionName; // 菜单名称

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

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Permission() {
		super();
	}

}
