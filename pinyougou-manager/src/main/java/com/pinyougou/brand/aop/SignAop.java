package com.pinyougou.brand.aop;

import com.pinyougou.brand.api.SignService;
import com.pinyougou.brand.entity.SignText;
import com.pinyougou.common.utils.RSAUtil;
import com.sun.tools.javac.util.Assert;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SignatureException;

@Aspect
@Component
public class SignAop {

    @Autowired
    private SignService signService;

    @Before("execution (* com.pinyougou.brand.controller.BrandController.queryOne(..) ) && args(authId , sign , signText)")
    public void verify(String authId , String sign, SignText signText) throws SignatureException {
        String publicKey = signService.getPublicKey(authId);
        Assert.checkNonNull(publicKey,"无法获取对应的公钥");
        Assert.check(RSAUtil.verify(signText.toText(),sign,publicKey),"签名验证失败");
    }
}
