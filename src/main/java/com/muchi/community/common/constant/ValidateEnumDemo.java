package com.muchi.community.common.constant;

/**
 * author: yuzq
 * create: 2020-04-14 09:54
 **/
public enum ValidateEnumDemo {
    Email,
    Phone;

    private String name;
    private String item;
    private String msg;


    static {
        Email.item="sasd";
        Email.msg="错误消息";
        Email.name="email";
    }

    public String getItem() {
        return item;
    }

    public static String forEachCountry(String index) {
        ValidateEnumDemo[] values = ValidateEnumDemo.values();
        for (ValidateEnumDemo countryEnum : values) {
            if (index.equals(countryEnum.name)) {
                return countryEnum.getMsg();
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public static void main(String[] args) {

    }
}
