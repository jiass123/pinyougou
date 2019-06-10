package com.asiainfo.sys.controller;

import com.asiainfo.common.entity.Result;
import com.asiainfo.inter.config.jwt.JwtUtil;
import com.asiainfo.sys.api.UserService;
import com.asiainfo.sys.entity.LoginCondition;
import com.asiainfo.sys.entity.LoginResult;
import com.asiainfo.sys.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
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

    private LoginResult getLoginResult(String accessToken,User user){
        LoginResult result = new LoginResult();
        result.setUsername(user.getUsername());
        result.setToken(accessToken);
        return result;
    }



}
