package com.muchi.community.common.utils;

import com.muchi.community.common.controller.Dog;
import com.muchi.community.common.controller.Student;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * 校验是否是java的自带字段类型
 * author: yuzq
 * create: 2020-04-16 11:38
 **/
public class CheckJavaClass {

    public static boolean isJavaClass(Class<?> clz) {

        return clz != null && clz.getClassLoader() == null;
    }

    public static void main(String[] args) {
        Student s=new Student();
        List<Dog> dogs=new ArrayList<>();
        Dog dog=new Dog();
        dog.setName("tt");
        dogs.add(dog);
        s.setDog(dogs);
        Class<? extends List> aClass = s.getDog().getClass();
        String name = aClass.getName();
        String typeName = aClass.getTypeName();
        TypeVariable<? extends Class<? extends List>>[] typeParameters = aClass.getTypeParameters();
        for (TypeVariable<? extends Class<? extends List>> typeParameter : typeParameters) {
            System.out.println(typeParameter);
        }


        System.out.println(CheckJavaClass.isJavaClass(s.getDog().getClass()));

    }
}
