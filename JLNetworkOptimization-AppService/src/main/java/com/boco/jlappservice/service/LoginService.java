package com.boco.jlappservice.service;

import com.boco.jlappservice.entity.request.LoginRequest;
import com.boco.jlappservice.entity.request.TerminalRecordRequest;
import com.boco.jlappservice.entity.response.LoginResponse;
import com.boco.jlappservice.entity.response.ResponseMessage2;
import com.boco.jlappservice.entity.response.UserResponseEntity;
import com.boco.jlappservice.entity.response.VerifyTokenResponse;

import java.util.ArrayList;

public interface LoginService {
    UserResponseEntity login(LoginRequest request);
}
