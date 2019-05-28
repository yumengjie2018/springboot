package com.example.service.controller;

import com.example.service.entity.response.MabitsResponse;
import com.example.service.service.MabitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * title：MabitsController
 * description:
 *
 * @author yumengjie
 * @date 2019/2/13 9:39
 */
@RestController
@RequestMapping(value = "/api/mabatis")
public class MabitsController {
    @Autowired
    private MabitsService service;

    @GetMapping("/getMabits")
    public MabitsResponse getMabits(){
        return  service.getMabits();
    }
}