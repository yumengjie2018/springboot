package com.boco.hnappservice.mapper;

import com.boco.hnappservice.entity.domainModel.UserEntity;

public interface LoginMapper {
    UserEntity getUser(String name);
}
