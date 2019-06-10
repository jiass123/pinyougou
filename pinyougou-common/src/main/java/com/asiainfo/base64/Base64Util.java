package com.asiainfo.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * base64 加密解密工具类
 * @author hanpeng
 * @date 2017-09-26
 */
public class Base64Util {

    /**
     * @description  解密
     * @author hanpeng
     * @date 2018/12/26 17:49
     */
	public static String decodeStr(String s) {
        byte[] b = null;  
        String result = null;  
        if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(s);  
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }

    /**
     * @description 加密
     * @parame str 加密的字符串
     * @author hanpeng
     * @date 2018/12/26 17:49
     */
    public static String encodeStr(String str) {
        byte[] b = null;  
        String s = null; 
        if (str != null) { 
        	try {  
                b = str.getBytes("utf-8");  
            } catch (UnsupportedEncodingException e) {  
                e.printStackTrace();  
            }  
            if (b != null) {  
                s = new BASE64Encoder().encode(b);  
            } 
        }
         
        return s;  
    }
}
