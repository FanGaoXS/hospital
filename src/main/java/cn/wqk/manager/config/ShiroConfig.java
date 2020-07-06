package cn.wqk.manager.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //3、subject
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager getDefaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(getDefaultWebSecurityManager);
        /*
            anon：无须认证就可以访问
            authc：必须认证了才可以访问
            user：必须拥有 记住我 才能访问
            perms：拥有对某个资源的权限才能访问
            role：拥有某项权限才可以访问
        */
        Map<String,String> filterMap=new LinkedHashMap<>();
        //过滤请求请求请求，重要的事情说三遍，不是过滤页面
        //这个请求无须认证都可以访问
        //filterMap.put("/*","anon");
        //这个请求必须认证了才能访问
        /*filterMap.put("/*","authc");*/
        // /admin/*请求需要admin权限才能访问
        filterMap.put("/manager/*","perms[manager]");
        // /doctor/*请求需要doctor权限才能访问
        filterMap.put("/doctor/*","perms[doctor]");
        // /patient/*请求需要patient权限才能访问
        filterMap.put("/patient/*","perms[patient]");
        // /test/*请求需要test权限才能访问
        /*filterMap.put("/test/*","perms[test]");*/
        // /guest/*请求需要guest权限才能访问
        /*filterMap.put("/guest/*","perms[guest]");*/
        bean.setFilterChainDefinitionMap(filterMap);
        //如果权限不够就会发起的请求（路由请求，返回没有权限）
        bean.setUnauthorizedUrl("/toUnauthor");
        //如果没有认证就会发送的请求请求（路由请求，让用户登录）
        bean.setLoginUrl("/toLogin");
        return bean;
    }
    //2、SecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("realm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //1、Realm
    @Bean(name = "realm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //shiroDialect:shiro整合thymeleaf
    @Bean(name="shiroDialect")
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
