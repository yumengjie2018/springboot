package com.boco.jlappservice.entity.request;

import com.boco.jlappservice.enums.NEGranularity;
import com.boco.jlappservice.enums.NETechnology;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：GetCellParametersRequest
 * description:小区参数请求对象
 *
 * @author yumengjie
 * @date 2020/3/7 16:30
 */
@Data
public class GetCellParametersRequest {

    @ApiModelProperty(value = "网元制式",example = "LTE")
    private NETechnology neTechnology;

    @ApiModelProperty(value = "网元编号")
    private String id;

    @ApiModelProperty(value = "网元粒度")
    private NEGranularity neGranularity;
}