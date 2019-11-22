package com.muchi.community.common.im;

import com.muchi.community.common.bean.WeatherMainVo;
import com.muchi.community.common.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/11/20   12:25
 */
@Component
public class WebsocketHandler extends TextWebSocketHandler {

    private static WeatherService weatherService;

    private static final Map<Long, WebSocketSession> SESSIONS = new HashMap<>();


    @Autowired
    public void setWeatherService(WeatherService weatherService){
        WebsocketHandler.weatherService=weatherService;
    }

    private static MLRobotService mLRobotService;

    @Autowired
    public void setmLRobotService(MLRobotService mLRobotService){
        WebsocketHandler.mLRobotService=mLRobotService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Long uid = (Long) session.getAttributes().get("uid");
        Long roomId = (Long) session.getAttributes().get("roomId");
        if(roomId==null){
            if(uid!=null){
                SESSIONS.put(uid,session);
                session.sendMessage(new TextMessage("用户"+uid+"欢迎登录！"));
                session.sendMessage(new TextMessage("发送消息，请以如下格式 用户Id，消息内容。请用中文逗号分开"));
                session.sendMessage(new TextMessage("例如： 1001，你好，你在干嘛呢？"));
            }else {
                session.sendMessage(new TextMessage("游客你好，欢迎登录！"));
                session.sendMessage(new TextMessage("你可以这样问，今天南昌天气怎么样？"));
                session.sendMessage(new TextMessage("或者，讲个笑话，小牧"));
                session.sendMessage(new TextMessage("又或者，跟我闲聊都可以！"));
                session.sendMessage(new TextMessage("更多彩蛋等你发现哦^_^！"));
            }
        }else {
            SESSIONS.put(uid,session);
            session.sendMessage(new TextMessage("欢迎进入"+roomId+"号群聊室！"));
            if(SESSIONS.get(roomId)!=null){
                SESSIONS.put(roomId,session);
            }
        }

    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Long uid = (Long) session.getAttributes().get("uid");
        Long roomId = (Long) session.getAttributes().get("roomId");
        if(roomId==null){
            if(uid==null){
                String msg = message.getPayload();
                String s = mLRobotService.mlRobot(msg);
                session.sendMessage(new TextMessage(s));
            }else {
                String[] split = message.getPayload().split("，");
                //获取需要发送的人
                WebSocketSession toSession = SESSIONS.get(Long.parseLong(split[0]));
                if (toSession != null && toSession.isOpen()) {
                    toSession.sendMessage(new TextMessage(split[1]));
                }else {
                    session.sendMessage(new TextMessage("对方不在线"));
                }
            }
        }else {
            WebSocketSession groupSession = SESSIONS.get(roomId);
            groupSession.sendMessage(new TextMessage(message.getPayload()));
        }

    }



    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Long uid = (Long) session.getAttributes().get("uid");
        SESSIONS.remove(uid);
        session.close();
    }
}
