package com.muchi.community.common.log;

import com.muchi.community.common.utils.CurrentUserUtil;
import com.muchi.community.user.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/8/15   15:54
 */
@Component("logAspect")
@Aspect
public class LogAspect {

    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut(value = "@annotation(com.muchi.community.common.log.Log)")
    public void logPointCut() {

    }

    @AfterReturning(pointcut = "logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        handleLog(joinPoint, null);
    }

    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e);
    }

    private void handleLog(JoinPoint joinPoint, Exception e) {
        try {
            Log annotationLog = getAnnotationLog(joinPoint);
            if (annotationLog == null) {
                return;
            }
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            String action = annotationLog.action();
            String title = annotationLog.title();
            StringBuilder sb = new StringBuilder();
            Object[] args = joinPoint.getArgs();
            int a = 1;
            for (Object o : args) {
                sb.append("第").append(a).append("个参数为").append(o.toString());
                a++;
            }

            User userLogin = CurrentUserUtil.getCurrentUser();
            logger.info("本次操作用户名为:{},{},备注为:{},类名为:{},方法名为:{},共有{}个参数,参数为{}", userLogin.getUserName(), title, action, className, methodName, args.length, sb.toString());
        } catch (Exception e1) {
            logger.info("==========前置通知异常=========");
            logger.info("异常信息为:" + e1.getMessage());
            e1.printStackTrace();
        }
    }

    private static Log getAnnotationLog(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(Log.class);
        }
        return null;
    }
}

