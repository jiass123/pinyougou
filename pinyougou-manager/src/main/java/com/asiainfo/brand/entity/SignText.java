package com.pinyougou.brand.entity;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 加密传输类的接口
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true) // 实现此接口的类 json格式化之后字段会以字典排序
public interface SignText {

    /**
     * 变成字符串的方法
     * @param object
     * @return
     */
     default String toText(){
         return JSON.toJSONString(this);
     }
}
