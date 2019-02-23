package com.pinyougou.sys.controller;

import com.pinyougou.common.constant.Constant;
import com.pinyougou.common.entity.Result;
import com.pinyougou.config.shiro.JwtToken;
import com.pinyougou.config.shiro.JwtUtil;
import com.pinyougou.sys.api.UserService;
import com.pinyougou.sys.entity.LoginCondition;
import com.pinyougou.sys.entity.LoginResult;
import com.pinyougou.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sys")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Result login(@RequestBody LoginCondition loginCondition){

        // 生成token
        String tokenStr = JwtUtil.sign(loginCondition.getUsername(), loginCondition.getPassword());
        JwtToken token = new JwtToken(tokenStr);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        // 登陆成功
        LoginResult loginResult = getLoginResult(loginCondition,tokenStr);
        return Result.ok(loginResult);
    }

    @GetMapping("/test")
    public Result test() {
        return Result.ok();
    }

    private LoginResult getLoginResult(LoginCondition loginCondition,String accessToken){
        User userQuery = new User();
        userQuery.setUsername(loginCondition.getUsername());
        User user = userService.queryOne(userQuery);
        LoginResult result = new LoginResult();
        result.setUsername(user.getUsername());
        result.setToken(accessToken);
        return result;
    }
}
