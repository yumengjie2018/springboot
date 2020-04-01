package com.boco.jlappservice.entity.response;

import com.boco.jlappservice.entity.domainModel.Payload;
import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    private Payload payload;


}




