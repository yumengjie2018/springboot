package com.boco.jlappservice.entity.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * title：LoginRequest
 * description:
 *
 * @author yumengjie
 * @date 2019/3/14 10:16
 */
@Data
public class LoginRequest implements Serializable {

    private static final long serialVersionUID = 6118080300401980744L;
    @ApiModelProperty(value = "用户名",required=true)
    private String name;
    @ApiModelProperty(value = "密码",required=true)
    private String password;
    @ApiModelProperty(value = "设备唯一标识",required=true)
    private String deviceId;

//    @ApiModelProperty(value = "客户端公钥",required = false)
//    private String clientPublicKey;
//    @ApiModelProperty(value = "时间戳",required = false)
//    private long timeSpan;
}