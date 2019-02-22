package com.pinyougou.sys.controller;

import com.pinyougou.common.entity.Result;
import com.pinyougou.sys.entity.LoginCondition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sys")
public class LoginController {

    @PostMapping("/login")
    public Result login(@RequestBody LoginCondition loginCondition){
        return null;
    }
}
