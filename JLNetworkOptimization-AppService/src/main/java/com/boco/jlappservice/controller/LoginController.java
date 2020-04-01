package com.boco.jlappservice.controller;

import com.boco.jlappservice.entity.request.LoginRequest;
import com.boco.jlappservice.entity.request.TerminalRecordRequest;
import com.boco.jlappservice.entity.response.LoginResponse;
import com.boco.jlappservice.entity.response.ResponseMessage2;
import com.boco.jlappservice.entity.response.UserResponseEntity;
import com.boco.jlappservice.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * title：LoginController
 * description:
 *
 * @author yumengjie
 * @date 2019/3/14 10:07
 */
@RestController
@RequestMapping("/app")
@Api(tags = "登陆接口")
@Slf4j
public class LoginController {
    @Autowired
    private LoginService service;


    @ResponseBody
    @PostMapping(value = "/login")
    @ApiOperation(notes = "登录 ", httpMethod = "POST", value = "登录认证;成功返回用户授权码，失败返回失败信息")
    public ResponseMessage2<UserResponseEntity> login(@ModelAttribute LoginRequest request ) {
            return ResponseMessage2.Success2(service.login(request));
    }

}