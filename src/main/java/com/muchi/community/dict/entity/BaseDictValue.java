package com.muchi.community.dict.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author yuzq
 * @since 2019-08-26
 */
@TableName("base_dict_value")
public class BaseDictValue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字典值
     */
    private String id;

    /**
     * 字典id
     */
    @TableField("dict_id")
    private String dictId;

    /**
     * 字典key
     */
    @TableField("dict_key")
    private String dictKey;

    /**
     * 字典value
     */
    @TableField("dict_val")
    private String dictVal;

    /**
     * 字典排序
     */
    @TableField("sort")
    private String sort;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Timestamp createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Timestamp updateTime;

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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BaseDictValue{" +
                "id=" + id +
                ", dictId=" + dictId +
                ", dictKey=" + dictKey +
                ", dictVal=" + dictVal +
                ", sort=" + sort +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
