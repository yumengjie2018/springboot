package com.example.service.controller;

import com.example.service.entity.response.BookResponse;
import com.example.service.entity.response.ResponseMessage;
import com.example.service.service.BookJpaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * title：BookJpaController
 * description:
 *
 * @author yumengjie
 * @date 2019/2/18 9:24
 */
@RestController
@RequestMapping("/api/book")
@Api(tags = "书名")
public class BookJpaController {
    @Autowired
    private BookJpaService service;
    @GetMapping(value = "/getBook")
    @ApiOperation(value = "获取书名")
    public BookResponse getBook(){
        return service.getBook();
    }
    @GetMapping(value = "/getTest1")
    public ResponseMessage get(){

        return ResponseMessage.Success();
    }
}