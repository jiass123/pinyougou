package com.asiainfo.brand.entity;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;


/**
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-02-23 23:37:05
 */
@Table(name = "tb_brand")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 设置：品牌名称
     */
    private String name;
    /**
     * 设置：品牌首字母
     */
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

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstChar='" + firstChar + '\'' +
                '}';
    }
}
