package com.muchi.community.common.controller;

import com.muchi.community.common.log.Dict;
import com.muchi.community.exception.MyIllegalArgumentException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: yuzq
 * create: 2020-04-16 11:46
 **/
@RestController
public class TestController {

    @RequestMapping("/testC")
    @Dict
    public String testC(@RequestBody Student student) throws MyIllegalArgumentException {
        System.out.println(student);
      return "";
    }
}
