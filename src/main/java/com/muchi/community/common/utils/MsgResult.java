package com.muchi.community.common.utils;

import com.muchi.community.common.constant.JsonConstant;

/**
 * @Author： yuzq
 * @Description: 返回消息和code的返回值类
 * @Date: 2019/9/8   21:54
 */
public class MsgResult {

    private Integer code;

    private String msg;

    private MsgResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static MsgResult success(){
        return new MsgResult(JsonConstant.SUCCESSCODE,JsonConstant.SUCCESS);
    }
}
