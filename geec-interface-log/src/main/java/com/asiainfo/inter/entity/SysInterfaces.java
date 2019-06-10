package com.asiainfo.entity;

import java.io.Serializable;


/**
 * 接口定义表
 *
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-05-06 17:40:48
 */
public class SysInterfaces implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer interfaceId;
    /**
     * 设置：接口调用方法
     */
    private String interfaceMethod;
    /**
     * 设置：接口编码
     */
    private String interfaceNo;
    /**
     * 设置：接口地址
     */
    private String interfaceUrl;
    /**
     * 设置：接口说明
     */
    private String interfaceDesc;

    /**
     * 设置：
     */
    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    /**
     * 获取：
     */
    public Integer getInterfaceId() {
        return interfaceId;
    }

    /**
     * 设置：接口调用方法
     */
    public void setInterfaceMethod(String interfaceMethod) {
        this.interfaceMethod = interfaceMethod;
    }

    /**
     * 获取：接口调用方法
     */
    public String getInterfaceMethod() {
        return interfaceMethod;
    }

    /**
     * 设置：接口编码
     */
    public void setInterfaceNo(String interfaceNo) {
        this.interfaceNo = interfaceNo;
    }

    /**
     * 获取：接口编码
     */
    public String getInterfaceNo() {
        return interfaceNo;
    }

    /**
     * 设置：接口地址
     */
    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    /**
     * 获取：接口地址
     */
    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    /**
     * 设置：接口说明
     */
    public void setInterfaceDesc(String interfaceDesc) {
        this.interfaceDesc = interfaceDesc;
    }

    /**
     * 获取：接口说明
     */
    public String getInterfaceDesc() {
        return interfaceDesc;
    }
}
