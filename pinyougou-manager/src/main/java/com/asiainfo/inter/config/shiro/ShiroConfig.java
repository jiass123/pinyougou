package com.asiainfo.inter.config.shiro;

import com.asiainfo.inter.config.properties.ShiroConfigProperties;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Autowired
    ShiroConfigProperties configProperties;

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(oAuth2Realm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());

        // 设置自定义过滤器
        Map<String, Filter> filterMap = new HashMap<String, Filter>();
        filterMap.put("oauth2", new OAuth2Filter());
        shiroFilterFactoryBean.setFilters(filterMap);

        // 设置请求拦截
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();

        // 测试请求
        filterChainDefinitionMap.put("/api/v1/sys/login", "anon");

        // 设置shiro开关
        if(configProperties.getEnable()){
            filterChainDefinitionMap.put("/**","oauth2");
        }
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public OAuth2Realm oAuth2Realm(){
        OAuth2Realm oAuth2Realm = new OAuth2Realm();
        return oAuth2Realm;
    }
}
