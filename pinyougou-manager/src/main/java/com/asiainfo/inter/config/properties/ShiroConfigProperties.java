package com.asiainfo.inter.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("shiro")
public class ShiroConfigProperties {

    private boolean enable = false;

    private int expireTime = 30 * 60 * 1000;

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime * 60 * 1000;
    }
}
