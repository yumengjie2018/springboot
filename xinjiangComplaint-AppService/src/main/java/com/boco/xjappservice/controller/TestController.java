package com.boco.xjappservice.controller;

import com.boco.xjappservice.entity.response.ResponseMessage2;
import com.boco.xjappservice.entity.response.ResponseStatus;
import com.boco.xjappservice.handle.MyException;
import com.boco.xjappservice.service.TestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * title：TestController
 * description:
 *
 * @author yumengjie
 * @date 2019/3/13 9:41
 */
@RestController
@RequestMapping("/app")
@Api(tags = "测试Oracle连接")
public class TestController {
    @Autowired
    private TestService service;
    @GetMapping("/testOracle")
    public ResponseMessage2<Integer> testOracle(String userId){

        System.out.println("000000");
        Integer ll=service.getTestOracle(userId);

        return ResponseMessage2.Success2(ll);
    }

}