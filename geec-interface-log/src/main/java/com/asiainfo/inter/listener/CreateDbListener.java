package com.asiainfo.inter.listener;

import com.asiainfo.inter.api.ISysInterfaceLogService;
import com.asiainfo.inter.api.ISysInterfacesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CreateDbListener implements ApplicationListener {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Integer count = 0;

    @Autowired
    private ISysInterfaceLogService sysInterfaceLogService;

    @Autowired
    private ISysInterfacesService sysInterfacesService;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(count == 0){
            logger.info("开始创建接口表，接口日志表----------------------");
            sysInterfaceLogService.createTable();
            sysInterfacesService.createTable();
            logger.info("结束创建接口表，接口日志表----------------------");
            count++;
        }
    }
}
