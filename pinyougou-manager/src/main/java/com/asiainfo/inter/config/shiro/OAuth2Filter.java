package com.asiainfo.config.shiro;

import com.alibaba.fastjson.JSON;
import com.asiainfo.common.entity.Result;
import com.asiainfo.config.jwt.JwtToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OAuth2Filter extends AuthenticatingFilter {

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = getRequestToken((HttpServletRequest) servletRequest);
        if(token == null){
            return null;
        }
        return new JwtToken(token);
    }

    /**
     * 判断请求是否直接允许通过 (不允许直接通过 需要进行token认证)
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    /**
     * 校验token是否存在 并且执行realm认证
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = getRequestToken((HttpServletRequest) servletRequest);
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(token == null){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            String json = JSON.toJSONString(Result.error(HttpStatus.UNAUTHORIZED.value(), "invalid token"));
            response.getWriter().write(json);
            return false;
        }
        return executeLogin(servletRequest,servletResponse);
    }

    /**
     * 认证失败处理
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        try {
            //处理登录失败的异常
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            Result result = Result.error(HttpStatus.UNAUTHORIZED.value(), throwable.getMessage());

            String json = JSON.toJSONString(result);
            httpResponse.getWriter().print(json);
        } catch (IOException e1) {
            return false;
        }
        return false;
    }

    private String getRequestToken(HttpServletRequest request){
        String token = request.getHeader("token");
        return token;
    }
}
