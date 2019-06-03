package com.boco.xjappservice.entity.domainModel;

import com.boco.xjappservice.entity.response.UserResponseEntity;
import lombok.Data;

/**
 * title：UserEntity
 * description:
 *
 * @author yumengjie
 * @date 2019/3/14 11:11
 */
@Data
public class UserEntity {

    private UserResponseEntity entity;
    private int isLocked;
    private String password;
    private int failedLoginCount;
}