package com.boco.jlappservice.mapper;

import com.boco.jlappservice.entity.domainModel.UserEntity;

public interface LoginMapper {

    UserEntity getUser(String name);
}
