package com.muchi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/25   19:31
 */
@Component
@ConfigurationProperties(prefix = "mail")
public class MailConfig {
    private String from;
    private String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
