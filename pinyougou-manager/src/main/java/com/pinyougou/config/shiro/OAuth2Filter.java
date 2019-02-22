package com.pinyougou.config.shiro;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class OAuth2Filter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        try {
            executeLogin(request, response);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected boolean executeLogin(ServletRequest servletRequest, ServletResponse response){
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        JwtToken jwtToken = new JwtToken(token);
        getSubject(request, response).login(jwtToken);
        return true;
    }

}
