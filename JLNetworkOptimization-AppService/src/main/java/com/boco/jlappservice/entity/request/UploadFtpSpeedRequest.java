package com.boco.jlappservice.entity.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：UploadFtpSpeedRequest
 * description:
 *
 * @author yumengjie
 * @date 2020/3/30 13:51
 */
@Data
public class UploadFtpSpeedRequest {
    @ApiModelProperty(value = "userId")
    private String userId;
    @ApiModelProperty(value = "日期(yyyy-mm-dd hh24:mi:ss)")
    private String  scanStartTime;
    @ApiModelProperty(value = "下载速度峰值")
    private float downloadSpeedPeak;
    @ApiModelProperty(value = "下载速度均值")
    private float downloadSpeedMean;
    @ApiModelProperty(value = "上传速度峰值")
    private float uploadSpeedPeak;
    @ApiModelProperty(value = "上传速度均值")
    private float uploadSpeedMean;
}