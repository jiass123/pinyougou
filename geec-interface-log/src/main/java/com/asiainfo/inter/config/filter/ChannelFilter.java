package com.asiainfo.inter.config.filter;

import com.asiainfo.inter.config.wrapper.RequestWrapper;
import com.asiainfo.inter.config.wrapper.ResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "channelFilter")
public class ChannelFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestWrapper requestWrapper = null;
        ResponseWrapper responseWrapper = null;
        if (servletRequest instanceof HttpServletRequest) {
            requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
        }
        if (servletResponse instanceof HttpServletResponse) {
            responseWrapper = new ResponseWrapper((HttpServletResponse) servletResponse);
        }
        if (requestWrapper == null || responseWrapper == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(requestWrapper, responseWrapper);
        }
        String result = responseWrapper.getResponseData();
        servletResponse.getOutputStream().write(result.getBytes());
    }

    @Override
    public void destroy() {

    }
}