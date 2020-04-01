package com.boco.jlappservice.service.impl;


import com.boco.jlappservice.entity.domainModel.TokenEntity;
import com.boco.jlappservice.entity.response.ResponseMessage2;
import com.boco.jlappservice.entity.response.ResponseStatus;
import com.boco.jlappservice.mapper.TokenDao;
import com.boco.jlappservice.utility.KryoUtil;
import com.boco.jlappservice.utility.SecurityUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * token业务
 * 1. 计算token
 * 2. 加密token
 * 3. 获取token(解密后)
 * 4. 解析token,返回对象模型
 * 5. 解析token,返回对象模型JSON数据
 * 6. 解析token,返回token验证验证错误响应数据
 * @author pangkang 2018-1-25 11:45:45
 */
@Service
public class TokenService {
	@Autowired
	private TokenDao dao;



	/**
	 * 计算token
	 * 
	 * @param  t 泛型参数
	 * @return 计算的token
	 */
	public <T extends Serializable> String generateToken(T t) {
		return KryoUtil.serializationObject(t);
	}

	/**
	 * token加密并保存
	 * 
	 * @param tokenEntity 待保存的token
	 */
	public void saveToken(TokenEntity tokenEntity) {
		tokenEntity.setToken(SecurityUtil.encryptBASE64(tokenEntity.getToken()));
		dao.saveToken(tokenEntity);

	}

	/**
	 * 获取toke
	 * @param userId 用户ID
	 * @return 用户的token值
	 */
	public String getToken(String userId) {
		String token = dao.getToken(userId);
		if (token == null) {
			return null;
		}
		return SecurityUtil.decryptBASE64(token);
	}

	/**
	 * 解析token，返回模型
	 *
	 * @param token token
	 * @param clazz 泛型数据
	 * @return 数据模型
	 */
	public <T extends Serializable> T decryptToken(String token, Class<T> clazz) {
		T p = KryoUtil.deserializationObject(token, clazz);
		return p;
	}

	/**
	 * 解析token,返回json串
	 * @param token
	 * @param clazz
	 * @return
	 */
	public <T extends Serializable> String decryptTokenToJson(String token, Class<T> clazz) {
		T p = KryoUtil.deserializationObject(token, clazz);
		return JSONObject.fromObject(p).toString();
	}
	
	/**
	 * 解析token,返回验证不通过时的响应数据
	 * @param token
	 * @param clazz
	 * @return
	 */
	public <T extends Serializable> String decryptTokenToResponse(String token, Class<T> clazz) {
		T p = KryoUtil.deserializationObject(token, clazz);
		return JSONObject.fromObject(ResponseMessage2.Failed(ResponseStatus.HAVE_LOGIN.getIndex(),"用户已登录",p)).toString();
	}
	
	public String returnNullToken(){
		return JSONObject.fromObject(ResponseMessage2.Failed(ResponseStatus.NULL_TOKEN.getIndex(),"未找到该用户登陆信息")).toString();
	}
	public String returnNullUserOrToken(){
		return JSONObject.fromObject(ResponseMessage2.Failed(ResponseStatus.NULL_USER_OR_TOKEN.getIndex(),"用户ID或者token不能为空")).toString();
	}

	public String returnIllegalUser(){
		return JSONObject.fromObject(ResponseMessage2.Failed(ResponseStatus.ILLEGAL_USER.getIndex(),"非法用户")).toString();
	}


}
