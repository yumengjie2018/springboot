package com.boco.jlappservice.entity.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：LogResponse
 * description:
 *
 * @author yumengjie
 * @date 2020/3/24 19:35
 */
@Data
public class LogResponse {
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    @ApiModelProperty(value = "插入时间")
    private String insertTime;
    @ApiModelProperty(value = "文件路径")
    private String filePath;
}