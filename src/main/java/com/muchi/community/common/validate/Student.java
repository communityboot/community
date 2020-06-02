package com.muchi.community.common.validate;

import javax.validation.constraints.Min;

/**
 * author: yuzq
 * create: 2020-04-16 10:02
 **/
public class Student {

    private String name;

    @Min(value = 16,message = "money最小值为16")
    private int money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
