package com.boco.jlappservice.enums;

public enum ResponseCodeEnum {
    NULL_TOKEN(112),
    NULL_USER_OR_TOKEN(113);
    private int code;

    ResponseCodeEnum(int code){
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}
