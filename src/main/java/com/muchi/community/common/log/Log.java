package com.muchi.community.common.log;

import java.lang.annotation.*;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/8/15   15:54
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String title() default "";

    String action() default "";
}
