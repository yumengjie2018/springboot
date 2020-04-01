package com.boco.jlappservice.controller;

import com.boco.jlappservice.entity.response.ResponseMessage2;
import com.boco.jlappservice.service.AppVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * title：AppVersionController
 * description:
 *
 * @author yumengjie
 * @date 2020/3/23 9:40
 */
@RestController
@RequestMapping(value = "/app/appVersion")
@Api(tags = "版本接口")
public class AppVersionController {
    @Autowired
    private AppVersionService service;

    @GetMapping("/getQRCodeURL")
    @ApiOperation("获取二维码链接")
    public ResponseMessage2<String> getQRCodeURL() throws Exception{

        return ResponseMessage2.Success2(service.getQRCodeURL());
    }

}