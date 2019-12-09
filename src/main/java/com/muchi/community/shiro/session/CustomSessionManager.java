package com.muchi.community.shiro.session;

import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/12/9   14:27
 */
public class CustomSessionManager extends DefaultWebSessionManager {

    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        Serializable sessionId = super.getSessionId(request, response);
        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "header");
        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);
        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
        return sessionId;
    }
}
