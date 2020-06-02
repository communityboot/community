package com.muchi.community.exception;

/**
 * author: yuzq 参数校验异常
 * create: 2020-04-16 14:07
 **/
public class MyIllegalArgumentException extends Exception{

    public MyIllegalArgumentException (){
        super();
    }

    public MyIllegalArgumentException(String message){
        super(message);
    }
}
