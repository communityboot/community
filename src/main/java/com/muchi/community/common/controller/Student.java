package com.muchi.community.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.muchi.community.common.validate.ValidationResult;
import com.muchi.community.common.validate.ValidationUtil;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * author: yuzq
 * create: 2020-04-16 11:47
 **/
public class Student {

    @Email(message = "邮箱格式错误")
    private String name;
    @Min(value = 11,message = "人年龄必须大于1")
    private int age;

    private List<Dog> dog;

    public List<Dog> getDog() {
        return dog;
    }

    public void setDog(List<Dog> dog) {
        this.dog = dog;
    }

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

    public static void main(String[] args) {
        Student student=new Student();
        student.setAge(22);
        student.setName("tom");
        Dog dog=new Dog();
        dog.setAge(2);
        dog.setName("dog");

        System.out.println(JSONObject.toJSONString(student));

        ValidationResult result = ValidationUtil.validateEntity(student);
        System.out.println(result.getErrorMsg());
    }
}
