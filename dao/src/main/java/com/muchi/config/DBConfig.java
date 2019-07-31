/*
package com.muchi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/25   18:49
 *//*

@Configuration
public class DBConfig {

    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/community?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("sa123");
        druidDataSource.setInitialSize(8);
        druidDataSource.setMinIdle(8);
        druidDataSource.setMaxActive(32);
        return druidDataSource;
    }
}
*/
