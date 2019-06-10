package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableAsync
@SpringBootApplication
@MapperScan({"com.asiainfo.*.mapper"})
//@ComponentScan({"com.asiainfo", "com.asiainfo"})
@ServletComponentScan
@EnableTransactionManagement
public class ManagerApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ManagerApplication.class);
    }
}
