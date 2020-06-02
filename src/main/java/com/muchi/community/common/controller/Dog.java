package com.muchi.community.common.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * author: yuzq
 * create: 2020-04-16 11:48
 **/
public class Dog {
    @NotNull(message = "狗不能为空")
    private String name;
    @Min(value = 20,message = "狗不需要20岁")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
