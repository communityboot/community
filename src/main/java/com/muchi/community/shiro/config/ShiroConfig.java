package com.muchi.community.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.muchi.community.shiro.session.CustomSessionManager;
import com.muchi.community.shiro.shiroRealm.MyRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置类
 * @author chenhuiqi
 *
 */
@Configuration
public class ShiroConfig {

	@Bean
	public MyRealm myRealm() {
		return  new MyRealm();
	}

	/**
	 * ShiroFilterFactoryBean 处理拦截资源文件问题。
	 * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
	 * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
	 * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
	 * 3、部分过滤器可指定参数，如perms，roles
	 */
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置不会被拦截的链接 顺序判断
		//filterChainDefinitionMap.put("/**", "anon");
		filterChainDefinitionMap.put("/webjars/**", "anon");
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/user/**", "anon");
		//filterChainDefinitionMap.put("/user/regist", "anon");
		filterChainDefinitionMap.put("/index/**", "anon");
		filterChainDefinitionMap.put("/regist", "anon");
		//filterChainDefinitionMap.put("/ws/**", "anon");
		//filterChainDefinitionMap.put("/group1/**", "anon");
		// 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean
	public SecurityManager securityManager(MyRealm myRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(myRealm);
		// 设置realm.
		securityManager.setRealm(myRealm);
		//设置session管理器
		securityManager.setSessionManager(sessionManager());
		//设置缓存管理器
		securityManager.setCacheManager(cacheManager());
		return securityManager;
	}

	/**
	 * Shiro生命周期处理器
	 * @return
	 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
	 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
	 * @return
	 */
	@Bean
	@DependsOn({ "lifecycleBeanPostProcessor" })
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	//开启shiro注解支持
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager(new MyRealm()));
		return authorizationAttributeSourceAdvisor;
	}


	/**
	 * cookie对象
	 * @return
	 */
	public SimpleCookie rememberMeCookie() {
		// 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
		SimpleCookie cookie = new SimpleCookie("rememberMe");
		// 设置cookie的过期时间，单位为秒，这里为一天
		cookie.setMaxAge(86400);
		return cookie;
	}


	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private int port;

	/**
	 * 1.redis的控制器，操作redis
	 */
	public RedisManager redisManager() {
		RedisManager redisManager = new RedisManager();
		redisManager.setHost("39.106.121.52");
		redisManager.setPort(6379);
		//redisManager.setTimeout(1800);
		return redisManager;
	}

	/**
	 * 2.sessionDao
	 */
	public RedisSessionDAO redisSessionDAO() {
		RedisSessionDAO sessionDAO = new RedisSessionDAO();
		sessionDAO.setRedisManager(redisManager());
		return sessionDAO;
	}

	/**
	 * 3.会话管理器
	 */
	public DefaultWebSessionManager sessionManager() {
		CustomSessionManager sessionManager = new CustomSessionManager();
		sessionManager.setSessionDAO(redisSessionDAO());
		//禁用cookie
		sessionManager.setSessionIdCookieEnabled(false);
		//禁用url重写   url;jsessionid=id
		sessionManager.setSessionIdUrlRewritingEnabled(false);
		return sessionManager;
	}

	/**
	 * 4.缓存管理器
	 */
	public RedisCacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setRedisManager(redisManager());
		return redisCacheManager;
	}
}
