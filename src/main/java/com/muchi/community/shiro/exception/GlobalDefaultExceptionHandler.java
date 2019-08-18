package com.muchi.community.shiro.exception;


import javax.servlet.http.HttpServletRequest;

import com.muchi.community.common.utils.JsonResult;
import org.apache.shiro.authz.UnauthorizedException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;




/**
  * 1、新建一个Class,这里取名为GlobalDefaultExceptionHandler
  * 2、在class上添加注解，@ControllerAdvice;
  * 3、在class中添加一个方法
  * 4、在方法上添加@ExcetionHandler拦截相应的异常信息；
  * 5、如果返回的是View -- 方法的返回值是ModelAndView;
  * 6、如果返回的是String或者是Json数据，那么需要在方法上添加@ResponseBody注解.
  * 
  * 
  *
   * @author ChenHQ
   * @title: GlobalDefaultExceptionHandler
   * @projectName community
   * @description: 全局捕获异常类
   * @date 2019/8/19
   */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {



    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public JsonResult defaultExceptionHandler(HttpServletRequest req, Exception e){
        System.out.println("进来了");
        JsonResult object = new JsonResult();
        object.setMsg("对不起，您无权访问");
        object.setStatus("200");
        object.setSuccess(false);
        return object;
    }
}
