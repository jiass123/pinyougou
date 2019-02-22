package com.pinyougou.config.shiro;

import com.pinyougou.sys.api.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private UserService userSerivce;

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
        String username = JwtUtil.getUsername(accessToken);
        if (username == null) {
            throw new AuthenticationException("token无效");
        }
//        if (userBean == null) {
//            throw new AuthenticationException("用户不存在!");
//        }
//
//        if (!JwtUtil.verify(accessToken, username, userBean.getPassword())) {
//            throw new AuthenticationException("用户名或密码错误");
//        }
        return new SimpleAuthenticationInfo(accessToken, accessToken, "");
    }
}