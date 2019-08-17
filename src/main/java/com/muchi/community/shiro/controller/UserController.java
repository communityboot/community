package com.muchi.community.shiro.controller;

import com.muchi.community.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping("/login")
	public Map<String, Object> login(User user, BindingResult bindingResult, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();

		// 1、JSR303
		if (bindingResult.hasErrors()) {
			map.put("success", false);
			map.put("errorInfo", bindingResult.getFieldError().getDefaultMessage());
			return map;
		}

		// 2、Shiro
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
		try {
			subject.login(token);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("errorInfo", "用户名或者密码错误!");
			return map;
		}
	}


}
