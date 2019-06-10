package com.pinyougou.sys.entity;

public class LoginResult {

    /**
     * 设置：用户名
     */
    private String username;

    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
