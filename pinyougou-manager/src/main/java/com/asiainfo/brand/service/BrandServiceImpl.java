package com.asiainfo.brand.service;

import com.asiainfo.brand.api.BrandService;
import com.asiainfo.brand.api.vo.BrandVO;
import com.asiainfo.brand.entity.Brand;
import com.asiainfo.brand.mapper.BrandMapper;
import com.asiainfo.common.entity.QueryQO;
import com.asiainfo.common.service.BaseServiceImpl;
import com.asiainfo.common.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service("brandService")
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements BrandService , QueryService {

	@Autowired
	private BrandMapper brandMapper;

	@Override
	public List<BrandVO> queryList(QueryQO queryQO) {
		return brandMapper.selectByQO(queryQO);
	}

    @Override
    public Integer queryCount(QueryQO queryQO) {
        return brandMapper.selectCountByQO(queryQO);
    }

    @Override
    @Transactional
    public void transcationTest() {
	    Brand brand = new Brand();
        brand.setFirstChar("T");
        brand.setName("事务测试");
        brandMapper.insert(brand);
//        try {
            int i = 1/0;
//        }catch (RuntimeException e){
//            System.out.println("捕获异常了。。");
//        }
//        new Thread(()->{
//            int i = 1/0;
//        }).start();
    }

    @Async
    @Override
    public void asyncTest(){
        try {
            TimeUnit.SECONDS.sleep(10);
            Brand brand = new Brand();
            brand.setFirstChar("T");
            brand.setName("事务测试");
            brandMapper.insert(brand);
            int i = 1/0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
