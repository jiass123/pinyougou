package com.asiainfo.brand.api.vo;

import com.fasterxml.jackson.annotation.JsonView;

public class BrandVO {

    private interface simpleView {};

    private static final long serialVersionUID = 1L;

    @JsonView(simpleView.class)
    private Long id;
    /**
     * 设置：品牌名称
     */
    @JsonView(simpleView.class)
    private String name;
    /**
     * 设置：品牌首字母
     */
    @JsonView(simpleView.class)
    private String firstChar;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：品牌名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：品牌名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：品牌首字母
     */
    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    /**
     * 获取：品牌首字母
     */
    public String getFirstChar() {
        return firstChar;
    }
}
