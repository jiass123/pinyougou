package com.pinyougou.config.security;

import com.pinyougou.config.properties.ShiroConfigProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ShiroConfigProperties.class)
public class SecurityCoreConfig {
}
