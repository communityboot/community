package com.muchi.community.common.utils;

import com.muchi.community.common.constant.JsonConstant;

/**
 * @Author： yuzq
 * @Description: 带数据的返回
 * @Date: 2019/9/16   20:21
 */
public class MzResult {

    private Integer code;

    private String msg;

    private Object data;

    private MzResult(Integer code, String msg,Object data) {
        this.code = code;
        this.msg = msg;
        this.data =data;
    }

    private MzResult(Integer code, String msg) {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static MzResult success(Object data){
        return new MzResult(JsonConstant.SUCCESSCODE,JsonConstant.SUCCESS,data);
    }

    public static MzResult successMsg(String msg){
        return new MzResult(JsonConstant.SUCCESSCODE,JsonConstant.SUCCESS,msg);
    }

    public static MzResult fail(){
        return new MzResult(JsonConstant.FAIL_CODE,JsonConstant.FAIL);
    }

    public static MzResult failMsg(String msg){
        return new MzResult(JsonConstant.FAIL_CODE,JsonConstant.FAIL,msg);
    }
}
