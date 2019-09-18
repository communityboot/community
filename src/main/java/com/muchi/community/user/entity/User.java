package com.muchi.community.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author yuzq
 * @since 2019-09-17
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户基础表id
     */
    private String id;

    /**
     * 社区表id
     */
    @TableField("communityId")
    private String communityId;

    /**
     * 用户名
     */
    @TableField("userName")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 删除标识
     */
    private Integer deltag;

    /**
     * 头像图片地址
     */
    @TableField("headPicUrl")
    private String headPicUrl;

    /**
     * 地址
     */
    private String address;

    /**
     * 性别0：男，1：女
     */
    private Integer gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 身份证
     */
    @TableField("idCard")
    private String idCard;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("updateTime")
    private Date updateTime;

    /**
     * 备注
     */
    private String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeltag() {
        return deltag;
    }

    public void setDeltag(Integer deltag) {
        this.deltag = deltag;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", communityId=" + communityId +
                ", userName=" + userName +
                ", password=" + password +
                ", phone=" + phone +
                ", status=" + status +
                ", email=" + email +
                ", deltag=" + deltag +
                ", headPicUrl=" + headPicUrl +
                ", address=" + address +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", realname=" + realname +
                ", idCard=" + idCard +
                ", salt=" + salt +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remarks=" + remarks +
                "}";
    }
}
