package com.example.service.excel.excelDemo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * title：RegionMobileInternetEntity
 * description:
 *
 * @author yumengjie
 * @date 2019/12/3 10:56
 */

public class RegionMobileInternetEntity {

    @ApiModelProperty("统计时间")
    @JsonFormat(pattern = IBaseConstant.DATE_PATTERN_FLAT)
    private Date statisticalTime;

    @ApiModelProperty("地市Id")
    private Integer regionId;

    @ApiModelProperty("地市名称")
    private String regionName;

    @ApiModelProperty("手机上网得分")
    private double mobileScore;

    @ApiModelProperty("不满意占比")
    private String unsatisfactoryProportion;

    @ApiModelProperty("不满意用户数")
    private int unsatisfactoryUsers;
}