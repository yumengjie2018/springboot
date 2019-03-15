package com.example.service.controller;

import com.example.service.repository.ParameterRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * title：ParameterList
 * description:
 *
 * @author yumengjie
 * @date 2019/2/28 17:32
 */
@RestController
@RequestMapping("/list")
public class ParameterList {
    @Autowired
    private ParameterRespository respository;
    public List<Map> queryList04(List list4){
        return respository.queryList04(list4);
    }
}