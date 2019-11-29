package com.muchi.community.common.im;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/11/20   12:29
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private MessageHandshakeInterceptor interceptor;

    @Autowired
    private GroupHandshakeInterceptor groupHandshakeInterceptor;

    @Autowired
    private ConversationInterceptor conversationInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/ws/robot").setAllowedOrigins("*");
        registry.addHandler(myHandler(), "/ws").setAllowedOrigins("*").addInterceptors(conversationInterceptor);
        registry.addHandler(myHandler(), "/ws/{id}").setAllowedOrigins("*").addInterceptors(interceptor);
        registry.addHandler(myHandler(), "/ws/{id}/{roomId}").setAllowedOrigins("*").addInterceptors(groupHandshakeInterceptor);
    }

    public WebSocketHandler myHandler(){
        return new WebsocketHandler();
    }
}
