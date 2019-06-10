package com.asiainfo.activti;

import org.activiti.engine.ProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitConfig {


    @Bean
    public ProcessEngineConfiguration processEngineConfiguration(){
        ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        // 设置数据库配置
        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration.setJdbcUsername("root");
        processEngineConfiguration.setJdbcPassword("123");
        processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/activit?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8");

        // 设置当数据库表不存在时 进行创建
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        return processEngineConfiguration;
    }

}
