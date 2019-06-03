package com.boco.xjappservice.utility;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RSA非对称加密
 * @author pangkang
 * 2018-08-01 09:39:41
 */
public class RsaUtil {

    private static String publicKeyString =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTHHqH2RTKUAfcijm8Hwe8SKlf6A0EpIOOxFMXkLkslP5g/GsEVK+cy0RJTX+QPLtMENrZTfcVBFU/eV8RcU3RhvDQqwAtzBsv5FCqP/AQi6Ol4IIYiNXRX3Mppc8TBj/8a5MWgWX4DtbCY0u1h4GEbvU1Ansiy5YknZ5JFiZeOQIDAQAB";
    private static String privateKeyString = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJMceofZFMpQB9yKObwfB7xIqV/oDQSkg47EUxeQuSyU/mD8awRUr5zLRElNf5A8u0wQ2tlN9xUEVT95XxFxTdGG8NCrAC3MGy/kUKo/8BCLo6XgghiI1dFfcymlzxMGP/xrkxaBZfgO1sJjS7WHgYRu9TUCeyLLliSdnkkWJl45AgMBAAECgYBOBqTWuMTWKWyCBK5qoOqxarirLaD5/WfpqSeJMDGG+9+QAVGhkmkyeH1Xg8tM7WlKBwaMi1WpyAqPCAjsb3QeAZ8t+seRoDkul5rNfdUnp+ktVzA9TgP/IW8vGEr4QyBj2pUh+GtdFDSl8d0+IQ462KOv0pvOiz/Zjc9aJg/0AQJBAPgnulOXCqPobrWgucd01xARY3jKdWGDyTndpRAG243+w6jedvObdu1sBshc9qjvIKorWCgL8GfRvSOyJ0vflqkCQQCXwwWJCbdWi9kJ2mHEDdTuR3QSEWVNX0AjW4nVKbjtYSm26iV+QZjCi7YT7WP4lOT8H6TzzSm8VU7Ohbt31ZURAkEAx/y8XMFNAes/zYBKOEQhTgG1eJMxJfVfJhNKAzCDoFvAs0cV9h1EKvL0RGUnI94TJRDpaty0Ufblxu68XJlEgQJAZFZ6mGomH0CDFPKf5QHIIGp5oWCC+67YNwhUjuzw6XFuJROWCm3QVAAPOAmiKT44T0GUy+R/jZdRbVYZ5lb+IQJBAJq34KscYbYQLAA5SJIH76PoeN5PPV3rooR7KK9YVh+THXANShB5U4JhBFQUqEdnkHtdMEKVVzAeBNYV7Ciy1vk=";

    public static String getPublicKeyString(){
        return publicKeyString;
    }
    public static String getPrivateKeyString(){
        return privateKeyString;
    }

    //私钥解密
    public static String decrypt(String content,String privateKeyString) throws Exception{
        byte[] contentByte = Base64.getDecoder().decode(content);
        PrivateKey privateKey = getPrivateKey(privateKeyString);
        byte[] result = decrypt(contentByte,privateKey);
        return new String(result);
    }
    //解密
    private static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception{
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }
    //将base64编码后的私钥字符串转成PrivateKey实例
    private static PrivateKey getPrivateKey(String privateKey) throws Exception{
        byte[ ] keyBytes= Base64.getDecoder().decode(privateKey.getBytes());
        PKCS8EncodedKeySpec keySpec=new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }
    //公钥加密
    public static String encrypt(String content,String publicKeyString)throws Exception{
        PublicKey publicKey = getPublicKey(publicKeyString);
        byte[] contentByte = content.getBytes();
        byte[] result = encrypt(contentByte,publicKey);
        return Base64.getEncoder().encodeToString(result);
    }
    private static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception{
        Cipher cipher=Cipher.getInstance("RSA");//java默认"RSA"="RSA/ECB/PKCS1Padding"
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }

    //将base64编码后的公钥字符串转成PublicKey实例
    private static PublicKey getPublicKey(String publicKey) throws Exception{
        byte[ ] keyBytes=Base64.getDecoder().decode(publicKey.getBytes());
        X509EncodedKeySpec keySpec=new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    //生成秘钥对
    public static KeyPair getKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator= KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        return keyPairGenerator.generateKeyPair();
    }

    //获取公钥字符串
    public static String getPublicKeyString(PublicKey key){
        return new String(Base64.getEncoder().encode(key.getEncoded()));
    }
    //获取私钥字符串
    public static String getPrivateKeyString(PrivateKey key){
        return new String(Base64.getEncoder().encode(key.getEncoded()));
    }
}
