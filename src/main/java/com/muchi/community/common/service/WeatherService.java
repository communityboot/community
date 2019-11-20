package com.muchi.community.common.service;

import com.alibaba.fastjson.JSONObject;
import com.muchi.community.admin.service.ISysCityService;
import com.muchi.community.common.bean.WeatherMainVo;
import com.muchi.community.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/11/20   11:55
 */
@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ISysCityService cityService;

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
