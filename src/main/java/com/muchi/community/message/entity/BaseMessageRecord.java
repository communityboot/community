package com.muchi.community.message.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author yuzq
 * @since 2019-09-07
 */
@TableName("base_message_record")
public class BaseMessageRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 消息id
     */
    @TableField("msgId")
    private Integer msgId;

    /**
     * 阅读时间
     */
    @TableField("readTime")
    private LocalDateTime readTime;

    /**
     * 是否阅读
     */
    @TableField("isRead")
    private Integer isRead;

    /**
     * 创建时间
     */
    @TableField("createDate")
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    @TableField("lastModified")
    private LocalDateTime lastModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public LocalDateTime getReadTime() {
        return readTime;
    }

    public void setReadTime(LocalDateTime readTime) {
        this.readTime = readTime;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "BaseMessageRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", msgId=" + msgId +
                ", readTime=" + readTime +
                ", isRead=" + isRead +
                ", createDate=" + createDate +
                ", lastModified=" + lastModified +
                "}";
    }
}