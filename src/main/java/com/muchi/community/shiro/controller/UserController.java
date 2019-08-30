package com.muchi.community.shiro.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.LayuiVo;
import com.muchi.community.common.utils.JsonResult;
import com.muchi.community.shiro.entity.User;
import com.muchi.community.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户首页login登录controller
 */
@Controller
@RequestMapping("/user")
public class UserController{

	@Autowired
	private UserService userService;


    /**
     * 用户登录
     * @param user
     * @param bindingResult
     * @param session
     * @return
     */
	@PostMapping("/login")
	@ResponseBody
	public Map<String, Object> login(User user, BindingResult bindingResult, HttpSession session,Boolean rememberMe) {
		Map<String, Object> map = new HashMap<String, Object>();

		// 1、JSR303
		if (bindingResult.hasErrors()) {
			map.put("success", false);
			map.put("errorInfo", bindingResult.getFieldError().getDefaultMessage());
			return map;
		}

		// 2、Shiro
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword(),rememberMe);
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

    /**
     * 用户注册
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping("/regist")
	@ResponseBody
    public JsonResult regist(User user, BindingResult bindingResult) {
        //创建返回对象
		JsonResult result = new JsonResult();

        // 1、JSR303验证是否有效
        if (bindingResult.hasErrors()) {
			result.setSuccess(false);
			result.setMsg(bindingResult.getFieldError().getDefaultMessage());
			result.setStatus("500");
            return result;
        }

        //调用service接口执行注册
		result = userService.registUser(user);

		return  result;
    }


	/**
	 * 加载指定页面
	 * @return
	 */
	@RequestMapping("/toUserPage")
	public String toUserPage() {
    	return "admin/user";
	}


	/**
	 * 分页查询（需要完善条件查询）
	 * @param page
	 * @param limit
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/userQuery")
	@ResponseBody
	public LayuiVo userQuery(Page page, @RequestParam("limit") int limit, @RequestParam(value = "page", defaultValue = "1") int currentPage, @RequestParam(required = false) User user) {
		page.setSize(limit);
		page.setCurrent(currentPage);
		List<User> users = userService.userQuery(page,user);
		LayuiVo layUiVo = new LayuiVo();
		layUiVo.setCode(0);
		layUiVo.setMsg("成功");
		layUiVo.setCount(page.getTotal());
		layUiVo.setData(users);
		return layUiVo;
	}



	@RequiresPermissions({"select"}) //没有的话 AuthorizationException
	@PostMapping("/select")
	@ResponseBody
	public Map<String, Object> selectPermission() {
		System.out.println("select");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前角色有查看的权力");
		return map;
	}

	@RequiresPermissions({"insert"}) //没有的话 AuthorizationException
	@PostMapping("/insert")
	@ResponseBody
	public Map<String, Object> insertPermission() {
		System.out.println("insert");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前角色有增加的权力");
		return map;
	}

	@RequiresPermissions({"update"}) //没有的话 AuthorizationException
	@PostMapping("/update")
	@ResponseBody
	public Map<String, Object> updatePermission() {
		System.out.println("update");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前角色有更新的权力");
		return map;
	}

	@RequiresPermissions({"delete"}) //没有的话 AuthorizationException
	@PostMapping("/delete")
	@ResponseBody
	public Map<String, Object> deletePermission() {
		System.out.println("delete");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前角色有删除的权力");
		return map;
	}

	@RequiresRoles({"vip"}) //没有的话 AuthorizationException
	@PostMapping("/vip")
	@ResponseBody
	public Map<String, Object> vipRole() {
		System.out.println("vip");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前用户具有 vip 角色");
		return map;
	}

	@RequiresRoles({"ip"}) //没有的话 AuthorizationException
	@PostMapping("/ip")
	@ResponseBody
	public Map<String, Object> ipRole() {
		System.out.println("ip");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前用户具有 ip 角色");
		return map;
	}

	@RequiresRoles({"p"}) //没有的话 AuthorizationException
	@PostMapping("/p")
	@ResponseBody
	public Map<String, Object> pRole() {
		System.out.println("vip");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前用户具有 p 角色");
		return map;
	}

}
