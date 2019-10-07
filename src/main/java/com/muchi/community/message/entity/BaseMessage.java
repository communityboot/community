package com.muchi.community.message.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;


import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author yuzq
 * @since 2019-09-07
 */
public class BaseMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 消息类型
     */
    @TableField("msgType")
    private Integer msgType;

    /**
     * 消息状态
     */
    @TableField("msgStatus")
    private Integer msgStatus;

    /**
     * 消息创建者
     */
    @TableField("msgCreator")
    private String msgCreator;

    /**
     * 消息发送者
     */
    @TableField("msgSender")
    private String msgSender;

    /**
     * 消息接收者
     */
    @TableField("msgReceiver")
    private String msgReceiver;

    /**
     * 消息标题
     */
    @TableField("msgTitle")
    private String msgTitle;

    /**
     * 消息内容
     */
    @TableField("msgContent")
    private String msgContent;

    /**
     * 消息概要
     */
    @TableField("msgSummary")
    private String msgSummary;

    /**
     * 生效时间
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("msgEffectTime")
    private Date msgEffectTime;

    /**
     * 失效时间
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("msgExpireTime")
    private Date msgExpireTime;

    /**
     * 登录ip
     */
    @TableField("loginIp")
    private String loginIp;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("createDate")
    private Date createDate;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("lastModified")
    private Date lastModified;

    /**
     * 备注
     */
    private String memo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Integer getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Integer msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getMsgCreator() {
        return msgCreator;
    }

    public void setMsgCreator(String msgCreator) {
        this.msgCreator = msgCreator;
    }

    public String getMsgSender() {
        return msgSender;
    }

    public void setMsgSender(String msgSender) {
        this.msgSender = msgSender;
    }

    public String getMsgReceiver() {
        return msgReceiver;
    }

    public void setMsgReciver(String msgReceiver) {
        this.msgReceiver = msgReceiver;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgSummary() {
        return msgSummary;
    }

    public void setMsgSummary(String msgSummary) {
        this.msgSummary = msgSummary;
    }

    public Date getMsgEffectTime() {
        return msgEffectTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public void setMsgEffectTime(Date msgEffectTime) {
        this.msgEffectTime = msgEffectTime;
    }

    public Date getMsgExpireTime() {
        return msgExpireTime;
    }

    public void setMsgExpireTime(Date msgExpireTime) {
        this.msgExpireTime = msgExpireTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "BaseMessage{" +
                "id=" + id +
                ", msgType=" + msgType +
                ", msgStatus=" + msgStatus +
                ", msgCreator=" + msgCreator +
                ", msgSender=" + msgSender +
                ", msgReceiver=" + msgReceiver +
                ", msgTitle=" + msgTitle +
                ", msgContent=" + msgContent +
                ", msgSummary=" + msgSummary +
                ", msgEffectTime=" + msgEffectTime +
                ", msgExpireTime=" + msgExpireTime +
                ", loginIp=" + loginIp +
                ", createDate=" + createDate +
                ", lastModified=" + lastModified +
                ", memo=" + memo +
                "}";
    }
}
