package com.example.service.controller;

import com.example.service.component.LoginResponseComponent;
import com.example.service.entity.request.UserRequest;
import com.example.service.entity.response.PageData;
import com.example.service.entity.response.ResponseMessage;
import com.example.service.entity.response.UserResponse;
import com.example.service.service.PageTestService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * title：PageTestController
 * description:
 *
 * @author yumengjie
 * @date 2019/11/29 15:32
 */
@RestController
@RequestMapping(value = "/app/page")
@Api(tags = "分页")
public class PageTestController {
    @Autowired
    private PageTestService service;
    @GetMapping("/getUserInfo")
   public ResponseMessage<PageData<UserResponse>> getUserInfo(UserRequest request){
       Page<UserResponse> userResponses=service.getUserInfo(request);
       return ResponseMessage.Success2(PageData.creat(userResponses.getTotal(), userResponses.getResult()));
   }
    @GetMapping("/getUserInfoTest")
    public ResponseMessage<List<UserResponse>> getUserInfoTest(){
        return ResponseMessage.Success2(service.getUserInfoTest());
    }
    @GetMapping("/getNullTest")
    public ResponseMessage getNullTest(){
        ResponseMessage responseMessage= ResponseMessage.Success2(null);
        ResponseMessage responseMessage1=responseMessage;
        ResponseMessage responseMessage2=new ResponseMessage();

        responseMessage2.setMessage("");
        responseMessage2.setStatus(-1);
        Object ll=null;
        responseMessage2.setData(ll);
        return responseMessage2;
    }
    @GetMapping("/getUser")
    @ApiOperation(value = "获取用户数")
    public ResponseMessage<Integer> getUser(){
        return ResponseMessage.Success2(LoginResponseComponent.getUser().size());
    }
}