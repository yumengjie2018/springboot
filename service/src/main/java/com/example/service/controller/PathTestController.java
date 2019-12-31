package com.example.service.controller;

import com.example.service.utils.UtilPath;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * title：PathTestController
 * description:
 *
 * @author yumengjie
 * @date 2019/11/22 15:03
 */
@RestController
@RequestMapping("/app/pathTest")
@Api(tags = "路径测试类")
public class PathTestController {
    @GetMapping(value = "/test")
    @ApiOperation(value = "测试路径")
    public void testPath(){

        System.out.println(""+UtilPath.getClassPath());
        System.out.println(""+UtilPath.getDate());
        System.out.println(""+UtilPath.getFreePath());
        System.out.println(""+UtilPath.getImages());
        System.out.println(""+UtilPath.getRootPath());

    }
}