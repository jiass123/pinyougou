package com.asiainfo.inter.inteceptor;

import com.asiainfo.inter.api.ISysInterfaceLogService;
import com.asiainfo.inter.api.ISysInterfacesService;
import com.asiainfo.inter.config.properties.SysInterfaceLogProperties;
import com.asiainfo.inter.config.wrapper.RequestWrapper;
import com.asiainfo.inter.config.wrapper.ResponseWrapper;
import com.asiainfo.inter.entity.SysInterfaceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.Set;

@Component
public class LogInterceptor implements HandlerInterceptor , InitializingBean {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    private Set<String> urls;

    @Autowired
    private ISysInterfacesService interfacesService;

    @Autowired
    private ISysInterfaceLogService interfaceLogService;

    @Autowired
    private SysInterfaceLogProperties sysInterfaceLogProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestWrapper requestWrapper = new RequestWrapper(request);
        for(String url : urls){
            if(request.getRequestURI().contains(url)){
                SysInterfaceLog sysInterfaceLog = new SysInterfaceLog();
                sysInterfaceLog.setRequestParam(getReqBody(requestWrapper));
                sysInterfaceLog.setInterfaceNo(getInterfaceNo(url));
                sysInterfaceLog.setIsCaller(Short.valueOf("0"));
                sysInterfaceLog.setRequestTime(new Date());
                interfaceLogService.saveReqLog(sysInterfaceLog);
                threadLocal.set(sysInterfaceLog.getLogId());
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        SysInterfaceLog sysInterfaceLog = interfaceLogService.queryByPrimaryKey(threadLocal.get());
        sysInterfaceLog.setResponseTime(new Date());
        ResponseWrapper responseWrapper = (ResponseWrapper)response;
        sysInterfaceLog.setResponseData(getResBody(responseWrapper));
        sysInterfaceLog.setIsCaller(Short.valueOf("1"));
        sysInterfaceLog.setResponseStatus(HttpStatus.OK.value());
        interfaceLogService.updateByPrimaryKey(sysInterfaceLog);
        threadLocal.remove();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(ex != null || threadLocal.get() != null){
            SysInterfaceLog sysInterfaceLog = interfaceLogService.queryByPrimaryKey(threadLocal.get());
            sysInterfaceLog.setResponseTime(new Date());
            ResponseWrapper responseWrapper = (ResponseWrapper)response;
            sysInterfaceLog.setResponseData(getResBody(responseWrapper));
            sysInterfaceLog.setIsCaller(Short.valueOf("1"));
            sysInterfaceLog.setResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            interfaceLogService.updateByPrimaryKey(sysInterfaceLog);
        }
    }

    /**
     * 加载需要记录日志的请求
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        urls = sysInterfaceLogProperties.getUrls();
    }

    /**
     * 获取请求体中的参数内容
     * @return
     */
    private String getReqBody(HttpServletRequest request) {
        BufferedReader br;
        String str, wholeStr = "";
        try {
            br = request.getReader();
            while((str = br.readLine()) != null){
                wholeStr += str;
            }
        } catch (IOException e1) {
            logger.error("获取请求体内容异常，异常信息:{}", e1.getMessage());
        }
        return wholeStr;
    }

    /**
     * 获取响应体中的参数内容
     * @param response
     * @return
     */
    private String getResBody(ResponseWrapper response) {
        String result = "";
        try {
            result = response.getResponseData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 获取接口编号
     * @return
     */
    private String getInterfaceNo(String url){
        String no = interfacesService.queryInterfaceNoByUrl(url);
        return no;
    }
}
