package com.muchi.community.common.im;

import com.muchi.community.common.bean.WeatherMainVo;
import com.muchi.community.common.service.WeatherService;
import com.muchi.community.common.utils.CurrentUserUtil;
import com.muchi.community.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/11/20   12:25
 */
@Component
public class WebsocketHandler extends TextWebSocketHandler {

    private static final Map<String, WebSocketSession> SESSIONS = new HashMap<>();

    private static MLRobotService mLRobotService;

    @Autowired
    public void setmLRobotService(MLRobotService mLRobotService){
        WebsocketHandler.mLRobotService=mLRobotService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("当前有 "+SESSIONS.size()+"人在线");
        String uid = (String) session.getAttributes().get("uid");
        String roomId = (String) session.getAttributes().get("roomId");
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
       // User currentUser = CurrentUserUtil.getCurrentUser();
        String uid = (String) session.getAttributes().get("uid");
        String roomId = (String) session.getAttributes().get("roomId");
        if(roomId==null){
            if(uid==null){
                String msg = message.getPayload();
                String s = mLRobotService.mlRobot(msg);
                session.sendMessage(new TextMessage(s));
            }else {
                String[] split = message.getPayload().split("，");
                //获取需要发送的人
                WebSocketSession toSession = SESSIONS.get(split[0]);
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
        String uid = (String) session.getAttributes().get("uid");
        SESSIONS.remove(uid);
        System.out.println("用户"+uid+"退出登录当前还有 "+SESSIONS.size()+"人在线");
        session.close();
    }
}
