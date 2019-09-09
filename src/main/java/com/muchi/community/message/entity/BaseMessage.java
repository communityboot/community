package com.muchi.community.message.entity;

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
public class BaseMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
    @TableField("msgEffectTime")
    private LocalDateTime msgEffectTime;

    /**
     * 失效时间
     */
    @TableField("msgExpireTime")
    private LocalDateTime msgExpireTime;

    /**
     * 登录ip
     */
    @TableField("loginIp")
    private String loginIp;

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

    /**
     * 备注
     */
    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setMsgCreater(String msgCreator) {
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

    public LocalDateTime getMsgEffectTime() {
        return msgEffectTime;
    }

    public void setMsgEffectTime(LocalDateTime msgEffectTime) {
        this.msgEffectTime = msgEffectTime;
    }

    public LocalDateTime getMsgExpireTime() {
        return msgExpireTime;
    }

    public void setMsgExpireTime(LocalDateTime msgExpireTime) {
        this.msgExpireTime = msgExpireTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
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
