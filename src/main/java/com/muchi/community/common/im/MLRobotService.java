package com.muchi.community.common.im;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/11/20   13:03
 */
@Service
public class MLRobotService {

    @Autowired
    private RestTemplate restTemplate;

    public String mlRobot(String question) throws UnsupportedEncodingException {
        String url="http://i.itpk.cn/api.php?question="+question+"&api_key=8d037f2d45bdb4ed14920980d736e857&api_secret=xq46nh5qqvby";
        String forObject;
        if(question.contains("笑话")){
          String  str = restTemplate.getForObject(url, String.class);
            Joke joke = JSONObject.parseObject(str, Joke.class);
            byte[] b=joke.getTitle().getBytes(StandardCharsets.UTF_8);
            byte[] b1=joke.getContent().getBytes(StandardCharsets.UTF_8);
            String title=new String(b, StandardCharsets.UTF_8);
            String content=new String(b1, StandardCharsets.UTF_8);
            forObject=title+"\n"+content;
        }else {
             forObject = restTemplate.getForObject(url, String.class);
        }
        return forObject;
    }
}
