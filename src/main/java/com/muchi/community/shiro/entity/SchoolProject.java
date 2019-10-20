package com.muchi.community.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author ChenHQ
 * @title: SchoolProject
 * @projectName community
 * @description:
 * @date 2019/10/20
 */
@TableName("school_project")
public class SchoolProject {

    private int id;

    private String username;

    private String phone;

    private String school;

    private String specialty;

    private String src;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "SchoolProject{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", school='" + school + '\'' +
                ", specialty='" + specialty + '\'' +
                ", src='" + src + '\'' +
                '}';
    }

    public SchoolProject(String username, String phone, String school, String specialty, String src) {
        this.username = username;
        this.phone = phone;
        this.school = school;
        this.specialty = specialty;
        this.src = src;
    }
}
