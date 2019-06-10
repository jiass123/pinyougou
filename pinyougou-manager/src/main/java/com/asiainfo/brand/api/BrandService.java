package com.asiainfo.brand.api;


import com.asiainfo.brand.entity.Brand;
import com.asiainfo.common.service.IBaseService;
import com.asiainfo.common.service.QueryService;

/**
 * 
 * 
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-02-23 23:37:05
 */
public interface BrandService  extends IBaseService<Brand> , QueryService {

    /**
     * 事务测试
     */
    void transcationTest();

    void asyncTest();
}
