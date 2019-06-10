package com.asiainfo.inter.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 接口日志表
 *
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-04-30 16:06:15
 */
public class SysInterfaceLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设置：主键
     */
    private Integer logId;
    /**
     * 设置：接口编号
     */
    private String interfaceNo;
    /**
     * 设置：请求发送时间
     */
    private Date requestTime;
    /**
     * 设置：请求头内容
     */
    private String requestHeader;
    /**
     * 设置：请求参数内容
     */
    private String requestParam;
    /**
     * 设置：响应接收时间
     */
    private Date responseTime;
    /**
     * 设置：响应状态码
     */
    private Integer responseStatus;
    /**
     * 设置：响应内容
     */
    private String responseData;
    /**
     * 设置：是否调用 0 被调用 1 调用
     */
    private Short isCaller;

    /**
     * 设置：主键
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * 获取：主键
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * 设置：接口编号
     */
    public void setInterfaceNo(String interfaceNo) {
        this.interfaceNo = interfaceNo;
    }

    /**
     * 获取：接口编号
     */
    public String getInterfaceNo() {
        return interfaceNo;
    }

    /**
     * 设置：请求发送时间
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * 获取：请求发送时间
     */
    public Date getRequestTime() {
        return requestTime;
    }

    /**
     * 设置：请求头内容
     */
    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    /**
     * 获取：请求头内容
     */
    public String getRequestHeader() {
        return requestHeader;
    }

    /**
     * 设置：请求参数内容
     */
    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    /**
     * 获取：请求参数内容
     */
    public String getRequestParam() {
        return requestParam;
    }

    /**
     * 设置：响应接收时间
     */
    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * 获取：响应接收时间
     */
    public Date getResponseTime() {
        return responseTime;
    }

    /**
     * 设置：响应状态码
     */
    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }

    /**
     * 获取：响应状态码
     */
    public Integer getResponseStatus() {
        return responseStatus;
    }

    /**
     * 设置：响应内容
     */
    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    /**
     * 获取：响应内容
     */
    public String getResponseData() {
        return responseData;
    }

    /**
     * 设置：是否调用 0 被调用 1 调用
     */
    public void setIsCaller(Short isCaller) {
        this.isCaller = isCaller;
    }

    /**
     * 获取：是否调用 0 被调用 1 调用
     */
    public Short getIsCaller() {
        return isCaller;
    }
}
