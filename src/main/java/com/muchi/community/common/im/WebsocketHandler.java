package com.muchi.community.common.im;

import com.muchi.community.common.bean.WeatherMainVo;
import com.muchi.community.common.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/11/20   12:25
 */
@Component
public class WebsocketHandler extends TextWebSocketHandler {

    private static WeatherService weatherService;

    @Autowired
    public void setWeatherService(WeatherService weatherService){
        WebsocketHandler.weatherService=weatherService;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
       // String msg=message.toString();
        String msg = message.getPayload();
        String substring = msg.substring(msg.length() - 2);
        if(substring.equals("天气")){
            String cityName = msg.substring(0, msg.length() - 2);
            WeatherMainVo w = weatherService.queryWeatherByName(msg);
            session.sendMessage(new TextMessage(cityName + "天气：" + w.getWea() + "，温度为: " + w.getTem() + "°，天气建议," + w.getAir_tips()));
        }else {
            msg=msg.replace("吗","");
            msg=msg.replace("我","我也");
            msg=msg.replace("？","！");
            session.sendMessage(new TextMessage(msg));
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
       session.sendMessage(new TextMessage("欢迎！"));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        session.sendMessage(new TextMessage("断开连接！"));
    }
}
