package com.boco.jlappservice.entity.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：DeleteLogRequest
 * description:
 *
 * @author yumengjie
 * @date 2020/3/24 17:08
 */
@Data
public class DeleteLogRequest {
    @ApiModelProperty(value = "用户Id")
    private String userId;
    @ApiModelProperty(value = "时间")
    private String insertTime;
}