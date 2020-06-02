package com.muchi.community.common.constant;

/**
 * author: yuzq
 * create: 2020-04-14 09:54
 **/
public enum ValidateEnum {
    Email(ValidateConstant.EMAIL, ValidateConstant.PHONE_REGEX, ValidateConstant.PHONE_REGEX),
    Phone("phone", "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$", "手机号格式错误");

    private String name;
    private String item;
    private String msg;


    ValidateEnum(String name, String item, String msg) {
        this.name = name;
        this.item = item;
        this.msg = msg;

    }

    public String getItem() {
        return item;
    }

    public static String forEachCountry(String index) {
        ValidateEnum[] values = ValidateEnum.values();
        for (ValidateEnum countryEnum : values) {
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
