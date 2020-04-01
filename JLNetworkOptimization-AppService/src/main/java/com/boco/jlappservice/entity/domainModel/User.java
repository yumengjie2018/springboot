package com.boco.jlappservice.entity.domainModel;

import lombok.Data;

@Data
public class User {
    private String userId;

    private String userName;

    private int regionId;

    private boolean isAdmin;

}
