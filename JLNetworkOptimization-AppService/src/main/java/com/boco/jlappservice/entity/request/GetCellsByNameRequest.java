package com.boco.jlappservice.entity.request;

import com.boco.jlappservice.enums.NETechnology;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：GetCellsByNameRequest
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 19:23
 */
@Data
public class GetCellsByNameRequest {

    @ApiModelProperty(value = "小区名称")
    private String cellName;

    @ApiModelProperty(value = "网元制式",example = "LTE")
    private NETechnology neTechnology;
}