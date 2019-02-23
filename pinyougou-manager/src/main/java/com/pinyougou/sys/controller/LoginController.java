package com.pinyougou.sys.controller;

import com.pinyougou.sys.entity.LoginCondition;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sys")
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody LoginCondition loginCondition){
        throw new AuthenticationException("测试");
    }
}
