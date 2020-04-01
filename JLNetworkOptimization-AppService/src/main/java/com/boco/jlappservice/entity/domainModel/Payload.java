package com.boco.jlappservice.entity.domainModel;


import lombok.Data;

@Data
public class Payload {
    private String sessionId;

    private String effective;

    private String expires;

    private User user;
}
