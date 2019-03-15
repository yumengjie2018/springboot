package com.boco.hnappservice.controller;

import com.boco.hnappservice.entity.request.LoginRequest;
import com.boco.hnappservice.entity.response.ResponseMessage2;
import com.boco.hnappservice.entity.response.UserResponseEntity;
import com.boco.hnappservice.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class LoginController {
    @Autowired
    private LoginService service;
    @PostMapping("/Login")
    @ApiOperation("原始登录认证;成功返回用户授权码，失败返回失败信息")
    public ResponseMessage2<UserResponseEntity> originalLogin(@ModelAttribute LoginRequest request) {
//        ResponseMessage2<UserResponseEntity> response=new ResponseMessage2<UserResponseEntity>();
        try {
            UserResponseEntity response=service.originalLogin(request);
            return ResponseMessage2.Success2(response);
        }catch (Exception e){
            return ResponseMessage2.Failed(e.toString());
        }
    }
}