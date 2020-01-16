package com.example.demo.config;

/*
import com.example.shiro.CustomFormAuthenticationFilter;
import com.example.shiro.CustomRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;
*/

import org.springframework.context.annotation.Configuration;

@Configuration

public class RedisConfig {
    /*@Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("192.168.61.130:6379");
        redisManager.setPassword("111111");
        redisManager.setDatabase(0);
        return redisManager;
    }

    @Bean
    public RedisSessionDAO redisSessionDAO(RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        return redisSessionDAO;
    }

    @Bean
    public RedisCacheManager cacheManager(RedisManager redisManager) {
        RedisCacheManager cacheManager = new RedisCacheManager();
        cacheManager.setRedisManager(redisManager);
        cacheManager.setPrincipalIdFieldName("id");
        return cacheManager;
    }

    @Bean
    public CustomRealm customRealm(HashedCredentialsMatcher credentialsMatcher) {
        CustomRealm customRealm = new CustomRealm();
        customRealm.setCredentialsMatcher(credentialsMatcher);
        return customRealm;
    }


    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1);
        return credentialsMatcher;
    }

    *//**
     * 会话管理器
     * @param redisSessionDAO
     * @return
     *//*
    @Bean
    public DefaultWebSessionManager sessionManager(RedisSessionDAO redisSessionDAO) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1800000);//session的失效时长，单位毫秒
        sessionManager.setDeleteInvalidSessions(true);//删除失效的session
        sessionManager.setSessionDAO(redisSessionDAO);
        return sessionManager;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(RedisCacheManager cacheManager,CustomRealm customRealm,DefaultWebSessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setCacheManager(cacheManager);
        securityManager.setRealm(customRealm);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    *//**
     * 自定义form认证过虑器
     * @return
     *//*
    @Bean
    public CustomFormAuthenticationFilter formAuthenticationFilter() {
        CustomFormAuthenticationFilter formAuthenticationFilter = new CustomFormAuthenticationFilter();
        formAuthenticationFilter.setUsernameParam("phone");//表单中账号的input名称
        formAuthenticationFilter.setPasswordParam("password");//表单中密码的input名称
        return formAuthenticationFilter;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager,CustomFormAuthenticationFilter formAuthenticationFilter) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/toLogin.htm");
        shiroFilter.setSuccessUrl("/");
        shiroFilter.setUnauthorizedUrl("/jsp/error-right.jsp");

        Map<String, Filter> filters = new HashMap<>();
        filters.put("authc",formAuthenticationFilter);
        shiroFilter.setFilters(filters);

        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        filterChainDefinitionMap.put("/login.htm","anon");//对登录设置匿名访问
        filterChainDefinitionMap.put("/toLogin.htm","anon");//对登录设置匿名访问
        filterChainDefinitionMap.put("/logout.htm","anon");

        filterChainDefinitionMap.put("/**","authc");//所有url都必须认证通过才可以访问
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilter;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }*/
}
