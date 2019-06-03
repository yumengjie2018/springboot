package com.boco.xjappservice.utility;


import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * 使用MD5进行签名算法
 * 将明文--》BASE64编码--》MD5加密--》截取第2到11位共10位--》MD5加密--》截取第2到11位共10位
 * 测试判据：
 * 明文：1533173682 密文：B89C784E6C
 * 明文：1533189238 密文：C8D7739632
 *
 * @author pangkang
 * 2018-08-02 09:05:30
 */
public class Md5SignUtil {
    /**
     * 将明文换算计算为签名值
     * @param origin 明文
     * @return 签名值
     */
    public static String getMd5SignResult(String origin) {
        origin = SecurityUtil.encryptBASE64(origin);
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        String result = encoder.encodePassword(origin,null).toUpperCase();
        result = encoder.encodePassword(result.substring(1,11),null).toUpperCase();
        return result.substring(1,11);
    }
}


