package com.muchi.community.common.validate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author： yuzq
 * @Description: 测试类
 * @Date: 2019/10/3   22:20
 */
public class Person {
    @NotEmpty(message = "姓名不能为空")
    private String name;


    @Min(value = 5,message = "最小值为5")
    private int age;

    @NotNull(message = "城市不能为空")
    private String city;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
