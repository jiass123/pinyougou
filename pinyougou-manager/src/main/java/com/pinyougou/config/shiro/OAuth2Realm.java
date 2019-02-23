package com.pinyougou.config.shiro;

import com.pinyougou.config.jwt.JwtToken;
import com.pinyougou.config.jwt.JwtUtil;
import com.pinyougou.sys.api.UserService;
import com.pinyougou.sys.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 支持jwtToken
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String accessToken = (String) authenticationToken.getCredentials();
        String username;
        try{
            username = JwtUtil.getUsername(accessToken);
        }catch (Exception e){
            throw new AuthenticationException("invalid token");
        }
        if (username == null) {
            throw new AuthenticationException("invalid token");
        }
        User userQuery = new User();
        userQuery.setUsername(username);
        User user = userService.queryOne(userQuery);
        if (user == null) {
            throw new AuthenticationException("invalid token");
        }
        if (!JwtUtil.verify(accessToken, username, user.getPassword())) {
            throw new AuthenticationException("invalid token");
        }
        return new SimpleAuthenticationInfo(accessToken, accessToken, getName());
    }
}
