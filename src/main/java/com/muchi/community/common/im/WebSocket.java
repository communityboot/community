package com.muchi.community.common.im;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/11/20   11:53
 */
//@ServerEndpoint("/websocket")
public class WebSocket {

    @OnOpen
    public void onOpen(Session session) throws IOException {
        System.out.println("已建立连接"+session);
        //向客户端发送消息
        session.getBasicRemote().sendText("你好，欢迎光临天上人间!");
        session.getBasicRemote().sendText("本次二号智能机器人将为您服务!");
    }

    @OnClose
    public void onClose(){
        System.out.println("连接已关闭");
    }

    @OnMessage
    public void onMessage(String msg,Session session) throws IOException{
        session.getBasicRemote().sendText("客服正在处理，请等待！");
        System.out.println("收到消息"+msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        msg=msg.replace("吗","");
        msg=msg.replace("我","我也");
        msg=msg.replace("？","！");
        session.getBasicRemote().sendText(msg);
    }
}
