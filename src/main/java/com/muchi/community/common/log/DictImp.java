package com.muchi.community.common.log;

import com.muchi.community.common.utils.CheckJavaClass;
import com.muchi.community.common.validate.ValidationResult;
import com.muchi.community.common.validate.ValidationUtil;
import com.muchi.community.exception.MyIllegalArgumentException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Map;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/2/1   22:26
 */
@Aspect
@Component
public class DictImp {
   // @Before("execution(* com.wuychn.springbootaspect.controller.*.*(..))") // 所有controller包下面的所有方法的所有参数
    //private HashMap<String,String> map=new HashMap<>();

    @Pointcut("")
    public void pointCut(){}


    public void beforeClass(JoinPoint joinPoint){}



    @Before("@annotation(com.muchi.community.common.log.Dict)")
    public void beforeMethod(JoinPoint joinpoint) throws IllegalAccessException, MyIllegalArgumentException {
        Object[] args = joinpoint.getArgs();
        ValidationResult validationResult=new ValidationResult();
        for (Object arg : args) {
            boolean res = CheckJavaClass.isJavaClass(arg.getClass());
            if(!res){
                 validationResult = ValidationUtil.validateEntity(arg);
            }
            Field[] declaredFields = arg.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                boolean isPrimary = CheckJavaClass.isJavaClass(declaredField.getType());
                if(!isPrimary){
                    declaredField.setAccessible(true);
                    Object o = declaredField.get(arg);
                    ValidationResult  result = ValidationUtil.validateEntity(o);
                    Map<String, String> errorMsg = validationResult.getErrorMsg();
                    Map<String, String> errorMsg1 = result.getErrorMsg();
                    if (null != errorMsg1) {
                        validationResult.setHasErrors(true);
                        for (String s : errorMsg1.keySet()) {
                            errorMsg.put(declaredField.getName()+s,errorMsg1.get(s));
                            validationResult.setErrorMsg(errorMsg);
                        }
                    }
                }
            }
        }
      if(validationResult.getErrorMsg()!=null){
          throw new MyIllegalArgumentException(validationResult.getErrorMsg().toString());
      }
    }


   // @AfterReturning(value = "@annotation(com.muchi.community.common.log.Dict)",returning = "obj")
    public void afterMethod(JoinPoint joinpoint, Object obj) throws IllegalAccessException {
        if(obj.getClass().getAnnotation(Dict.class)!=null){
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if(declaredField.getAnnotation(Dict.class)!=null){
                    declaredField.setAccessible(true);
                    declaredField.setInt(obj,456);
                }
            }
        }
        System.out.println("处理后"+obj);
    }

}
