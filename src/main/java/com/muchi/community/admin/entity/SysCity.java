package com.muchi.community.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 * 城市表
 * </p>
 *
 * @author yuzq
 * @since 2019-11-19
 */
public class SysCity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @TableField("cityEn")
    private String cityEn;

    @TableField("cityZh")
    private String cityZh;

    @TableField("provinceEn")
    private String provinceEn;

    @TableField("provinceZh")
    private String provinceZh;

    @TableField("countryEn")
    private String countryEn;

    @TableField("countryZh")
    private String countryZh;

    @TableField("leaderEn")
    private String leaderEn;

    @TableField("leaderZh")
    private String leaderZh;

    private String lat;

    private String lon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityEn() {
        return cityEn;
    }

    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }

    public String getCityZh() {
        return cityZh;
    }

    public void setCityZh(String cityZh) {
        this.cityZh = cityZh;
    }

    public String getProvinceEn() {
        return provinceEn;
    }

    public void setProvinceEn(String provinceEn) {
        this.provinceEn = provinceEn;
    }

    public String getProvinceZh() {
        return provinceZh;
    }

    public void setProvinceZh(String provinceZh) {
        this.provinceZh = provinceZh;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public String getCountryZh() {
        return countryZh;
    }

    public void setCountryZh(String countryZh) {
        this.countryZh = countryZh;
    }

    public String getLeaderEn() {
        return leaderEn;
    }

    public void setLeaderEn(String leaderEn) {
        this.leaderEn = leaderEn;
    }

    public String getLeaderZh() {
        return leaderZh;
    }

    public void setLeaderZh(String leaderZh) {
        this.leaderZh = leaderZh;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "SysCity{" +
                "id=" + id +
                ", cityEn=" + cityEn +
                ", cityZh=" + cityZh +
                ", provinceEn=" + provinceEn +
                ", provinceZh=" + provinceZh +
                ", countryEn=" + countryEn +
                ", countryZh=" + countryZh +
                ", leaderEn=" + leaderEn +
                ", leaderZh=" + leaderZh +
                ", lat=" + lat +
                ", lon=" + lon +
                "}";
    }
}
