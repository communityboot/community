package com.muchi.community.exception;

import com.muchi.community.common.utils.MzResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author： yuzq
 * Description: ControllerAdvice增强 全局异常处理，数据绑定，数据预处理
 * Date: 2020/2/26   9:10
 */
@RestControllerAdvice
public class MyException {

    public MzResult nullPointEx(NullPointerException ex){

        return MzResult.fail();
    }

    @ExceptionHandler(MyIllegalArgumentException.class)
    public MzResult mIllegalArgumentException(MyIllegalArgumentException ex){
        System.out.println(ex.getMessage());
        return MzResult.failMsg(ex.getMessage());
    }

}
