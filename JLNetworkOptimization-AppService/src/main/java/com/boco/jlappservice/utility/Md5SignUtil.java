package com.boco.jlappservice.utility;

import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.codec.Utf8;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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
     * @return 签名值
     */
    private Md5SignUtil() {

    }

    public static String getMd5SignResult(String origin) throws UnsupportedEncodingException {
        origin = SecurityUtil.encryptBASE64(origin);
        String result = encode(origin).toUpperCase();
        result = encode(result.substring(1,11)).toUpperCase();
        return result.substring(1,11);
    }



    private static String encode(String rawPass) {
        MessageDigest messageDigest = getMessageDigest();
        byte[] digest = messageDigest.digest(Utf8.encode(rawPass));
        return new String(Hex.encode(digest));
    }

    private final static MessageDigest getMessageDigest(){
        try {
            return MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(
                    "No such algorithm [" + "MD5" + "]");
        }
    }
}


