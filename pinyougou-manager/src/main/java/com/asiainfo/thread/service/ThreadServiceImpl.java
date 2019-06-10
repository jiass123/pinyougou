package com.asiainfo.thread.service;

import com.asiainfo.brand.mapper.BrandMapper;
import com.asiainfo.thread.api.IThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("threadService")
public class ThreadServiceImpl implements IThreadService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public void test(){
        System.out.println("开始睡觉");
        try {
            Thread.sleep(2*60000+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束睡觉");
        brandMapper.selectAll();
        System.out.println("结束查询");
    }
}
