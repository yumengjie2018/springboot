package com.boco.jlappservice.entity.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：UploadLogResponse
 * description:日志上传返回值
 *
 * @author yumengjie
 * @date 2020/3/24 9:55
 */
@Data
public class UploadLogResponse {
    @ApiModelProperty(value = "日志名称")
    private String logName;
    @ApiModelProperty(value = "日志记录时间")
    private String logTime;
}