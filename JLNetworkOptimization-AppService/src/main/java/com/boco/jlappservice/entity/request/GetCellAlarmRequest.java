package com.boco.jlappservice.entity.request;

import com.boco.jlappservice.enums.NEGranularity;
import com.boco.jlappservice.enums.NETechnology;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：GetCellAlarmRequest
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 19:04
 */
@Data
public class GetCellAlarmRequest {

    @ApiModelProperty(value = "网元制式")
    private NETechnology neTechnology;

    @ApiModelProperty(value = "网元编号")
    private String id;

    @ApiModelProperty(value = "网元粒度")
    private NEGranularity neGranularity;

}