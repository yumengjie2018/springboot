package com.example.service.mapper;

import com.example.service.entity.request.UserRequest;
import com.example.service.entity.response.UserResponse;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PageTestReponsitory {
    List<UserResponse> getUserInfo(UserRequest request);

    List<UserResponse> getUserInfoTest();
}
