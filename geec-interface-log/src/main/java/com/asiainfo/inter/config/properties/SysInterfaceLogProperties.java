package com.asiainfo.inter.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashSet;
import java.util.Set;

@ConfigurationProperties("inter")
public class SysInterfaceLogProperties {

    private String url;

    private Set<String> urls = new HashSet<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        String[] urlArray = url.split(",");
        if(urlArray.length > 1 ){
            for(int i = 0 ; i < urlArray.length ; i++){
                urls.add(urlArray[i]);
            }
        }else{
            urls.add(url);
        }
    }

    public Set<String> getUrls() {
        return urls;
    }
}
