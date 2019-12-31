package com.example.service.service.impl;

import com.example.service.entity.request.UserRequest;
import com.example.service.entity.response.UserResponse;
import com.example.service.mapper.PageTestReponsitory;
import com.example.service.service.PageTestService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * title：PageTestServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2019/11/29 15:40
 */
@Service
public class PageTestServiceImpl implements PageTestService {
    @Autowired
    private PageTestReponsitory reponsitory;
    @Override
    public Page<UserResponse> getUserInfo(UserRequest request) {
        Page<UserResponse> userResponses=PageHelper.startPage(request.getPageIndex(),request.getPageSize(),true);
        reponsitory.getUserInfo(request);
        return userResponses;
    }

    @Override
    public List<UserResponse> getUserInfoTest() {
        return reponsitory.getUserInfoTest();
    }
}