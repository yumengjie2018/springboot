package com.boco.hnappservice.controller;

import com.boco.hnappservice.service.TestService;
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
@RequestMapping("/api")
@Api(tags = "测试Oracle连接")
public class TestController {
    @Autowired
    private TestService service;
    @GetMapping("/testOracle")
    public int testOracle(String userId){

        System.out.println("000000");
        return service.getTestOracle();
    }

}