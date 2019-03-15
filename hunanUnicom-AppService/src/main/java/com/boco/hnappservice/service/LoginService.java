package com.boco.hnappservice.service;

import com.boco.hnappservice.entity.request.LoginRequest;
import com.boco.hnappservice.entity.response.UserResponseEntity;

public interface LoginService {
    UserResponseEntity originalLogin(LoginRequest request) throws Exception;
}
