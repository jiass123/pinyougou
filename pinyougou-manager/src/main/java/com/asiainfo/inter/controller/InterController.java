package com.asiainfo.inter.controller;

import com.asiainfo.common.exception.GlobalException;
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
//        throw new RuntimeException("测试异常");
        return "abc";
    }
}

