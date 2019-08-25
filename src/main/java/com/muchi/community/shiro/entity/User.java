package com.muchi.community.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * shiro 权限 user 类
 */
@TableName("t_user")
public class User {

	private String id;

	@NotEmpty(message = "用户名不能为空")
	@TableField("user_name")
	private String userName;  //用户名

	@NotEmpty(message = "密码不能为空")
	private String password;  //密码

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}

}
