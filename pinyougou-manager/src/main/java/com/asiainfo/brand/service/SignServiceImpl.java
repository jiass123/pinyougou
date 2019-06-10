package com.asiainfo.brand.service;

import com.asiainfo.brand.api.SignService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SignServiceImpl implements SignService {

    static Map<String,String> key = new HashMap<>();

    static {
        key.put("10086","MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDVxlQoDoaS2FR+WsJbO6UxzMY2\n" +
                "KEKNoQWaGs8m5417ctHsC688weR6txw5oIPHtOZUg7hLUCUoFMWKV//ONzd+wO75\n" +
                "I9MTdWp234kbcbS2CcWgIgsHGVVPDYEVpOq0Cm6yjh3WSKrDFpTwODuWQ/rW7iZn\n" +
                "vEojFaeFCKcSJPoKEwIDAQAB");
    }

    @Override
    public String getPublicKey(String authId) {
        return key.get(authId);
    }
}
