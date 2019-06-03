package com.boco.xjappservice.service;

import com.boco.xjappservice.entity.request.LoginRequest;
import com.boco.xjappservice.entity.response.UserResponseEntity;

public interface LoginService {
    UserResponseEntity originalLogin(LoginRequest request) throws Exception;
}
