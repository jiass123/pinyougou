package com.pinyougou.brand.controller;

import com.pinyougou.brand.api.BrandService;
import com.pinyougou.brand.api.qo.BrandQO;
import com.pinyougou.brand.entity.Brand;
import com.pinyougou.common.entity.Result;
import com.pinyougou.common.holder.PageQueryHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-02-23 23:37:05
 */
@RestController
@RequestMapping("/api/v1/brand")
public class BrandController implements InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BrandService brandService;

    @Autowired
    private PageQueryHolder<BrandQO> pageQueryHolder;

    @Override
    public void afterPropertiesSet() {
        pageQueryHolder.setQueryService(brandService);
    }

    @PostMapping("/queryList")
    public Result queryBrandList(@RequestBody BrandQO brandQO) {
        return pageQueryHolder.queryList(brandQO);
    }

    @PostMapping("/add")
    public Result addBrand(@RequestBody Brand brand){
        logger.info("添加请求参数:{}",brand);
        brandService.add(brand);
        return Result.ok();
    }

    @GetMapping("/queryOne/{id}")
    public Result queryOne(@PathVariable Integer id){
        logger.info("查询单个参数:{}",id);
        Brand brand = brandService.queryByPrimaryKey(id);
        return Result.ok(brand);
    }

    @PostMapping("/update")
    public Result updateBrand(@RequestBody Brand brand){
        logger.info("修改请求参数:{}",brand);
        brandService.updateByPrimaryKey(brand);
        return Result.ok();
    }

    @PostMapping("/delete")
    public Result deleteBrand(@RequestBody Integer[] ids){
        logger.info("删除请求参数:{}",ids.toString());
        for (Integer id : ids) {
            brandService.deleteByPrimaryKey(id);
        }
        return Result.ok();
    }
}
