package com.muchi.community.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author yuzq
 * @since 2019-09-14
 */
@TableName("base_user_interest")
public class BaseUserInterest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 兴趣表主键
     */
    private String id;

    /**
     * 用户Id
     */
    @TableField("userId")
    private String userId;

    /**
     * 小区地址
     */
    @TableField("communityAddress")
    private String communityAddress;

    /**
     * 房屋号
     */
    @TableField("houseAddress")
    private String houseAddress;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 年龄段
     */
    @TableField("ageGroup")
    private Boolean ageGroup;

    /**
     * 篮球
     */
    @TableField("basketBall")
    private Boolean basketBall;

    /**
     * 喜欢美食
     */
    @TableField("gourmetFood")
    private Boolean gourmetFood;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommunityAddress() {
        return communityAddress;
    }

    public void setCommunityAddress(String communityAddress) {
        this.communityAddress = communityAddress;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(Boolean ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Boolean getBasketBall() {
        return basketBall;
    }

    public void setBasketBall(Boolean basketBall) {
        this.basketBall = basketBall;
    }

    public Boolean getGourmetFood() {
        return gourmetFood;
    }

    public void setGourmetFood(Boolean gourmetFood) {
        this.gourmetFood = gourmetFood;
    }

    @Override
    public String toString() {
        return "BaseUserInterest{" +
                "id=" + id +
                ", userId=" + userId +
                ", communityAddress=" + communityAddress +
                ", houseAddress=" + houseAddress +
                ", gender=" + gender +
                ", ageGroup=" + ageGroup +
                ", basketBall=" + basketBall +
                ", gourmetFood=" + gourmetFood +
                "}";
    }
}
