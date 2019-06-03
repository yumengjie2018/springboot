package com.boco.xjappservice.utility;

/**
 * 比对密码
 * @author pangkang
 * 2018-1-23 14:22:52
 */
public class PasswordEncoder {
	public static boolean matches(String origin,String destination) {
		if (destination == null || destination.length() == 0) {
			return false;
		}
		String init;
		String pwd = "";
		try {
			//获取请求端的密码
			String rsaPassWord = RsaUtil.decrypt(origin,RsaUtil.getPrivateKeyString());
			init = SecurityUtil.decryptBase64(rsaPassWord);
			pwd = SecurityUtil.SHA1AndBASE64(init);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return !pwd.equals("") && pwd.equals(destination);
	}
}
