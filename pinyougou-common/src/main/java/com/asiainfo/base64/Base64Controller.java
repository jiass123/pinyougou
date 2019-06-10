package com.asiainfo.base64;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/base64")
public class Base64Controller {

    @RequestMapping("/test")
    public void test(String params){
        String s = Base64Util.decodeStr(params);
        System.out.println(s);
    }
}
