package com.pinyougou.common.entity;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", 200);
    }

    public static Result error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    public static Result ok(Object data){
        Result result = new Result();
        result.put("msg","success");
        result.put("result", data);
        return result;
    }

    public static Result ok() {
        Result result = new Result().put("msg", "success");
        return result;

    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}