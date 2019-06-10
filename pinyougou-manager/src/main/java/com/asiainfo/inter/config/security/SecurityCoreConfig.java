package com.asiainfo.config.security;

import com.asiainfo.config.properties.ShiroConfigProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ShiroConfigProperties.class)
public class SecurityCoreConfig {
}
