package com.muchi.community.dict.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuzq
 * @since 2019-08-13
 */
@TableName("base_dict")
public class BaseDict implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableField("id")
    private String id;

    /**
     * 存的字典名称
     */
    @TableField("dictName")
    private String dictName;

    /**
     * 字典显示名称
     */
    @TableField("dictLabel")
    private String dictLabel;

    /**
     * 是否启用
     */
    private Integer enabled;

    /**
     * 如不启用，填写备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseDict{" +
                "dictName=" + dictName +
                ", dictLabel=" + dictLabel +
                ", enabled=" + enabled +
                ", remark=" + remark +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
