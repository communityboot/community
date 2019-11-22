package com.muchi.community.common.im;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Component
public class GroupHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        String path = request.getURI().getPath();
        String[] ss = StringUtils.split(path, '/');
        if(ss.length != 4){
            return false;
        }
        if(!StringUtils.isNumeric(ss[2]) || !StringUtils.isNumeric(ss[3])){ //是否为数字
            return false;
        }
        attributes.put("uid", Long.valueOf(ss[2]));
        attributes.put("roomId",Long.valueOf(ss[3]));
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
