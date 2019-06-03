package com.boco.xjappservice.mapper;

import com.boco.xjappservice.entity.domainModel.UserEntity;

public interface LoginMapper {
    UserEntity getUser(String name);
}
