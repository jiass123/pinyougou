package com.pinyougou.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("shiro")
public class ShiroConfigProperties {

    private boolean enable = false;

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
