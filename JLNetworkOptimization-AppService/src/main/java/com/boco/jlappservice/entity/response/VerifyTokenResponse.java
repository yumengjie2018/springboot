package com.boco.jlappservice.entity.response;

import com.boco.jlappservice.entity.domainModel.User;
import lombok.Data;

@Data
public class VerifyTokenResponse {
    private String sessionId;

    private String effective;

    private String expires;

    private User user;
}
