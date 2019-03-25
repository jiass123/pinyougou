package com.pinyougou;

import com.pinyougou.brand.entity.BrandParams;
import com.pinyougou.common.utils.RSAUtil;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RSATest {

    private String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANXGVCgOhpLYVH5a\n" +
            "wls7pTHMxjYoQo2hBZoazybnjXty0ewLrzzB5Hq3HDmgg8e05lSDuEtQJSgUxYpX\n" +
            "/843N37A7vkj0xN1anbfiRtxtLYJxaAiCwcZVU8NgRWk6rQKbrKOHdZIqsMWlPA4\n" +
            "O5ZD+tbuJme8SiMVp4UIpxIk+goTAgMBAAECgYEAtYpql2XWhMfv4SnkGaQqYoM6\n" +
            "5G0GL85Jupf/yVMkxGw6t1Eo7Njf1hLAhnO41ZTbcXQ2wsZ593LEWvrmQtKDbbRZ\n" +
            "SB5hG/oWXSWUCwIugQf93AoYQWe5C2x+ly6nqp5cFqorB0+xts6eUJVhsBHsgZe5\n" +
            "00Ib1JYJYNLeymNaEKkCQQD1GNLHCrIndKU9PpYQDs6XDnj5B2E2Wrten0B9Xpcd\n" +
            "htv++zeqtKrG/nZq2RTWFNIAct5ue/PXY5EGgE0WLGmlAkEA30jOW04fC0MVrbYh\n" +
            "PlVTDFRqC64geHNkyAwjX1RSN9sF50EeUlYgZ6rBVtj5n3s5XpBZI9wXToC2TSgx\n" +
            "yoInVwJAC9FemGpTnMNrFEDoS23rWC1Cd/97GHvXfQCAw4rEDpBqGylRzdFYSrAK\n" +
            "VayR7KCkX5EqWHlxkHkkjQOys9cAYQJBAK1oy+sZZv7GIQYCVxskBRWkUZ+0oj8p\n" +
            "z3GWC7qzsA71KUaKylPD0/LvKKycYnG7r7iDftdczTUIvYx61QCjyI0CQQDlQ/5W\n" +
            "J+TGkrfaZ/B80LNUwjfA3v62be68edxjlzClZ3W2O7NM8mIYvi4GdyM/nZv8x5YF\n" +
            "oNsoSAj5/GXmKnRt";

    private String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDVxlQoDoaS2FR+WsJbO6UxzMY2\n" +
            "KEKNoQWaGs8m5417ctHsC688weR6txw5oIPHtOZUg7hLUCUoFMWKV//ONzd+wO75\n" +
            "I9MTdWp234kbcbS2CcWgIgsHGVVPDYEVpOq0Cm6yjh3WSKrDFpTwODuWQ/rW7iZn\n" +
            "vEojFaeFCKcSJPoKEwIDAQAB";

    @Test
    public void ARSASign(){
        BrandParams brand = new BrandParams();
        brand.setId(1L);
        String sgin = RSAUtil.sign(brand.toText(), privateKey);
        System.out.println(sgin);
    }

}
