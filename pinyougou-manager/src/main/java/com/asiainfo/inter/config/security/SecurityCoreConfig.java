package com.asiainfo.inter.config.security;

import com.asiainfo.inter.config.properties.ShiroConfigProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ShiroConfigProperties.class)
public class SecurityCoreConfig {
}
