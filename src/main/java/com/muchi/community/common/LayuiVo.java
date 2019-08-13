package com.muchi.community.common;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/29   22:43
 */
public class LayuiVo {
    protected Integer code;

    protected String msg;

    protected Long count;

    protected Object data;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LayuiVo(){}

    public LayuiVo(Integer code, String msg, Long total, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
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
}
