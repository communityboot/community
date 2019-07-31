package com.muchi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @Author： yuzq
 * @Description: 对应的字典详情表
 * @Date: 2019/7/29   21:16
 */
@TableName("base_dict_value")
public class DictValue {

    @TableField("id")
    private String id;

    @TableField("dict_id")
    private String dictId;

    @TableField("dict_key")
    private String dictKey;

    @TableField("dict_val")
    private String dictVal;

    @TableField("sort")
    private String sort;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictVal() {
        return dictVal;
    }

    public void setDictVal(String dictVal) {
        this.dictVal = dictVal;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

