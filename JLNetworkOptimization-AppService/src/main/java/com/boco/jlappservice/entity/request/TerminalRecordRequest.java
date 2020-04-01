package com.boco.jlappservice.entity.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：TerminalRecordRequest
 * description:获取登陆的终端设备的信息
 *
 * @author yumengjie
 * @date 2020/3/6 9:37
 */
@Data
public class TerminalRecordRequest {

    @ApiModelProperty(value = "终端具体品牌")
    private String terminal;

    @ApiModelProperty(value = "终端厂商品牌")
    private String terminalBrand;

    @ApiModelProperty(value = "终端版本号")
    private String terminalVersion;

    @ApiModelProperty(value = "系统版本号")
    private String systemVersion;
}