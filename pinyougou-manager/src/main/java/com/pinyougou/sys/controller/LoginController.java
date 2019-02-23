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
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/sys")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Result login(@RequestBody LoginCondition loginCondition) throws AuthenticationException {

        // 生成token
        User user = checkUser(loginCondition);
        String tokenStr = JwtUtil.sign(loginCondition.getUsername(), loginCondition.getPassword());

        // 登陆成功
        LoginResult loginResult = getLoginResult(tokenStr,user);
        return Result.ok(loginResult);
    }

    private User checkUser(LoginCondition loginCondition) throws AuthenticationException {
        User userQuery = new User();
        userQuery.setUsername(loginCondition.getUsername());
        User user = userService.queryOne(userQuery);
        if(user == null){
            throw new AuthenticationException("用户不存在");
        }
        if(!user.getPassword().equals(loginCondition.getPassword())){
            throw new AuthenticationException("用户名或密码错误");
        }
        return user;
    }

    @GetMapping("/test")
    public Result test() {
        return Result.ok();
    }

    private LoginResult getLoginResult(String accessToken,User user){
        LoginResult result = new LoginResult();
        result.setUsername(user.getUsername());
        result.setToken(accessToken);
        return result;
    }



}
