package com.muchi.community.common.utils;

/**
 * @author ChenHQ
 * @title: JsonResult
 * @projectName community
 * @description: TODO
 * @date 2019/8/19
 */

/**
 * Describe: 封装Json返回信息
 */
public class JsonResult {
    private Boolean success;
    private String status;
    private String msg;
    private Object obj;

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "success=" + success +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}
