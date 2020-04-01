package com.boco.jlappservice.entity.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：CellAnalysisRequest
 * description:小区分析请求值
 *
 * @author yumengjie
 * @date 2020/3/27 13:44
 */
@Data
public class CellAnalysisRequest {
    @ApiModelProperty(value = "LTE 或 GSM")
    private String networkType;
    @ApiModelProperty(value = "小区名称")
    private String cellName;
}