package com.muchi.community.user.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/9/14   15:22
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String,String> kmap=new HashMap<>();
        kmap.put("first","1");
        kmap.put("second","2");
        kmap.put("third","3");
        kmap.put("fourth","4");
        kmap.put("fifth","5");
        kmap.put("six","6");

        System.out.println(kmap);
        kmap.remove("six");
        System.out.println(kmap);

    }
}
