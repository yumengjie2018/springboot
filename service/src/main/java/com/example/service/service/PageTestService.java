package com.example.service.service;

import com.example.service.entity.request.UserRequest;
import com.example.service.entity.response.UserResponse;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * title：PageTestService
 * description:
 *
 * @author yumengjie
 * @date 2019/11/29 15:40
 */

public interface PageTestService {

    Page<UserResponse> getUserInfo(UserRequest request);

    List<UserResponse> getUserInfoTest();
}