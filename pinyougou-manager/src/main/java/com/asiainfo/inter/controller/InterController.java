package com.pinyougou.inter.controller;

import com.pinyougou.brand.api.BrandService;
import com.pinyougou.brand.api.qo.BrandQO;
import com.pinyougou.brand.entity.Brand;
import com.pinyougou.common.entity.Result;
import com.pinyougou.common.exception.GlobalException;
import com.pinyougou.common.holder.PageQueryHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

/**
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-02-23 23:37:05
 */
@RestController
@RequestMapping("/api/v1/inter")
public class InterController {

    @GetMapping("/test")
    public String interTest(@RequestBody String transParameter) {
        throw new GlobalException("测试异常");
//        return "abc";
    }
}

