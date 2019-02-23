package com.pinyougou.brand.controller;

import com.pinyougou.brand.api.BrandService;
import com.pinyougou.brand.api.qo.BrandQO;
import com.pinyougou.common.entity.Result;
import com.pinyougou.common.holder.PageQueryHolder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-02-23 23:37:05
 */
@RestController
@RequestMapping("/api/v1/brand")
public class BrandController implements InitializingBean {

    @Autowired
    private BrandService brandService;

    @Autowired
    private PageQueryHolder<BrandQO> pageQueryHolder;

    @Override
    public void afterPropertiesSet() {
        pageQueryHolder.setQueryService(brandService);
    }

    @PostMapping("queryList")
    public Result queryBrandList(@RequestBody BrandQO brandQO) {
        return pageQueryHolder.queryList(brandQO);
    }

}
