package com.muchi.community.common.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/9/20   13:41
 */
@Controller
@RequestMapping("/http")
public class HttpClientController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getJson")
    @ResponseBody
    public String getJson(){
        String url="https://www.tianqiapi.com/api/?version=v1&cityid=101240110&appid=87381976&appsecret=1qtJKYBo";
        ResponseEntity<JSONObject> exchange = restTemplate.exchange(url, HttpMethod.GET, null, JSONObject.class);
        return  exchange.getBody().toString();

    }

}
