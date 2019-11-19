package com.muchi.community.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.muchi.community.admin.service.ISysCityService;
import com.muchi.community.common.bean.WeatherMainVo;
import com.muchi.community.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/weather")
public class HttpClientController {

    @Value("${weather.appId}")
    private String appId;


    @Value("${weather.appSecret}")
    private String appSecret;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ISysCityService cityService;

    @RequestMapping("/getCurrentDay")
    @ResponseBody
    public WeatherMainVo getJson(){
        String url="https://www.tianqiapi.com/api/?version=v6&cityid=101240110&appid=87381976&appsecret=1qtJKYBo";
        ResponseEntity<JSONObject> exchange = restTemplate.exchange(url, HttpMethod.GET, null, JSONObject.class);
        String string = exchange.getBody().toString();
        WeatherMainVo weatherMainVo = JSONObject.parseObject(string, WeatherMainVo.class);
        return weatherMainVo;
    }

    @RequestMapping("/queryWeaByName")
    @ResponseBody
    public WeatherMainVo queryWeatherByName(String cityName){
        String cityName1 = cityService.getIdByCityName(cityName);
        if(StringUtils.isEmpty(cityName1)){
            cityName1="101010100";
        }
        String url="https://www.tianqiapi.com/api/?version=v6&cityid="+cityName1+"&appid=87381976&appsecret=1qtJKYBo";
        ResponseEntity<JSONObject> exchange = restTemplate.exchange(url, HttpMethod.GET, null, JSONObject.class);
        String string = exchange.getBody().toString();
        WeatherMainVo weatherMainVo = JSONObject.parseObject(string, WeatherMainVo.class);
        return weatherMainVo;
    }

}
