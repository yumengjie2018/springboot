package com.boco.jlappservice.entity.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：CellAnalysisResponse
 * description:小区分析返回值
 *
 * @author yumengjie
 * @date 2020/3/27 13:41
 */
@Data
public class CellAnalysisResponse {
    @ApiModelProperty(value = "小区名称")
    private String cellName;
    @ApiModelProperty(value = "百度经度")
    private double baiduLongitude;
    @ApiModelProperty(value = "百度纬度")
    private double baiduLatitude;
}