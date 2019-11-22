package com.muchi.community.shiro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.constant.JsonConstant;
import com.muchi.community.common.utils.*;
import com.muchi.community.shiro.entity.SchoolProject;
import com.muchi.community.shiro.service.SchoolProjectService;
import com.muchi.community.user.entity.User;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户首页login登录controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SchoolProjectService schoolProjectService;

    /**
     * 用户登录
     *
     * @param user
     * @param bindingResult
     * @param session
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(User user, BindingResult bindingResult, HttpSession session, Boolean rememberMe) {
        Map<String, Object> map = new HashMap<String, Object>();

        // 1、JSR303
        if (bindingResult.hasErrors()) {
            map.put("success", false);
            map.put("errorInfo", bindingResult.getFieldError().getDefaultMessage());
            return map;
        }

        // 2、Shiro
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword(), rememberMe);

        try {
            subject.login(token);
            map.put("success", true);
//			MzResult unReadMessageNum = messageController.getUnReadMessageNum();
//			map.put("unReadNum",unReadMessageNum.getData());
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
     *
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

        return result;
    }

    /**
     * 用户触发文件状态改变
     *
     * @return
     */
    @PostMapping("/uploadFile")
    @ResponseBody
    public LayuiVo uploadFile(MultipartFile fileUpload) {
        //创建返回对象
		String string= FastDFSClient.uploadFile(fileUpload);
		String url = FastDFSClient.getResAccessUrl(string);

        return LayuiVo.successCustomMsg(url);
    }

    /**
     * 用户提交相关信息
     *
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public LayuiVo upload(HttpServletRequest request) {
        //创建返回对象
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String school = request.getParameter("school");
        String specialty = request.getParameter("specialty");
        String src = request.getParameter("src");

        //字段判空
        if(username==null||school==null){
            return LayuiVo.failCustomMsg("用户名、学校为必填项");
        }

        SchoolProject schoolProject = new SchoolProject(username,phone,school,specialty,src);
        schoolProjectService.saveSchoolProject(schoolProject);


        return LayuiVo.successByMsg();
    }


    /**
     * 加载指定页面
     *
     * @return
     */
    @RequestMapping("/toUserPage")
    public String toUserPage() {
        return "admin/user";
    }


    /**
     * 分页查询（需要完善条件查询）
     *
     * @param limit       每页显示条数
     * @param currentPage 当前页
     * @return 用户信息
     */
    @RequestMapping("/userQuery")
    @ResponseBody
    public LayuiVo userQuery(@RequestParam("limit") int limit, @RequestParam(value = "page", defaultValue = "1") int currentPage) {
        Page<User> page = new Page<>(currentPage, limit);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        IPage<User> userIPage = userService.userQuery(page, wrapper);
        return LayuiVo.successLayui(userIPage.getTotal(), userIPage.getRecords());
    }

    @RequestMapping("/userSearch")
    @ResponseBody
    public LayuiVo userSearch(@RequestParam("limit") int limit, @RequestParam(value = "page", defaultValue = "1") int currentPage, User user) {
        Page<User> page = new Page<>(currentPage, limit);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (user != null) {
            wrapper.lambda().eq(!user.getUserName().equals(""), User::getUserName, user.getUserName())
                    .eq(!user.getPhone().equals(""), User::getPhone, user.getPhone())
                    .eq(!user.getEmail().equals(""), User::getEmail, user.getEmail())
                    .eq(user.getGender() != null, User::getGender, user.getGender())
                    .eq(user.getStatus() != null, User::getStatus, user.getStatus())
                    .eq(!user.getAddress().equals(""), User::getAddress, user.getAddress());
        }
        IPage<User> userIPage = userService.userQuery(page, wrapper);
        return LayuiVo.successLayui(userIPage.getTotal(), userIPage.getRecords());
    }

    @PostMapping("/delUserBatch")
    @ResponseBody
    public LayuiVo delUserBatch(@RequestParam(value = "ids[]") String[] ids) {
        List<String> dictIds = Arrays.asList(ids);
        if (userService.removeByIds(dictIds)) {
            return LayuiVo.successCustomMsg(JsonConstant.DELSUCCESS);
        }
        return LayuiVo.failCustomMsg(JsonConstant.DELFAIL);
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

    @RequestMapping("/uploadAvatar")
    @ResponseBody
    public MzResult uploadAvatar(MultipartFile file) {
        String avatarUrl = FastDFSClient.uploadImageAndCrtThumbImage(file);
        if (avatarUrl != null) {
            String id = CurrentUserUtil.getCurrentUser().getId();
            String preAvatarUrl = userService.getById(id).getHeadPicUrl();
            //获取之前的头像地址，如果不为空则删除服务器存的图片，节省内存
            if (preAvatarUrl != null) {
                FastDFSClient.deleteFile(preAvatarUrl);
            }
            User user = new User();
            user.setId(id);
            user.setHeadPicUrl(avatarUrl);
            boolean b = userService.updateById(user);
            if (b) {
                return MzResult.successMsg(JsonConstant.UPDATESUCCESS);
            }
        }
        return MzResult.failMsg(JsonConstant.UPDATEFAIL);
    }

}
