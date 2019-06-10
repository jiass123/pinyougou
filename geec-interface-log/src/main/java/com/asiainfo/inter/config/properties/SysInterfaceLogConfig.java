package com.asiainfo.config.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SysInterfaceLogProperties.class)
public class SysInterfaceLogConfig {
}
