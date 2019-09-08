package com.muchi.community.common.utils;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/29   22:43
 */
public class LayuiVo {
    private Integer code;

    protected String msg;

    private Long count;

    protected Object data;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LayuiVo(){}

    private LayuiVo(Integer code, String msg, Long total, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.count = total;
        this.data = data;
    }

    public LayuiVo(Integer code,String msg){
        this.code=code;
        this.msg=msg;
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


    /**
     * 请求成功并返回数据
     * @param total 总数
     * @param data 数据
     * @return 数据
     */
    public static LayuiVo successByData(Long total,Object data){
        return new LayuiVo(200,"请求成功！",total,data);
    }


    public static LayuiVo successLayui(Long total,Object data){
        return new LayuiVo(0,"请求成功！",total,data);
    }

    /**
     *
     * @return 请求成功提示信息
     */
    public static LayuiVo successByMsg(){
        return new LayuiVo(200,"请求成功！");
    }

    public static LayuiVo successCustomMsg(String msg){
        return new LayuiVo(200,msg);
    }

    /**
     * @return 请求失败提示信息
     */
    public static LayuiVo failByMsg(){
        return new LayuiVo(200,"请求失败！");
    }

    public static LayuiVo failCustomMsg(String msg){
        return new LayuiVo(200,msg);
    }

    /**
     * @return 错误信息带数据
     */
    public static LayuiVo failByData(Long total,Object data){
        return new LayuiVo(100,"请求失败！",total,data);
    }

    /**
     * @return 参数错误信息返回信息
     */
    public static LayuiVo paramError( ){
        return new LayuiVo(400,"参数错误！");
    }


    /**
     * 需要登录
     * @return 返回需要登录的Json信息
     */
    public static LayuiVo needLogin(){
        return new LayuiVo(401,"请登录!");
    }

    /**
     * 需要登录
     * @return 返回需要登录的Json信息
     */
    public static LayuiVo needAuth(){
        return new LayuiVo(403,"当前用户无权限!");
    }

    @Override
    public String toString() {
        return "LayuiVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
