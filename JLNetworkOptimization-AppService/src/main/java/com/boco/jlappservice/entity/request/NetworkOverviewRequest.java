package com.boco.jlappservice.entity.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * title：NetworkOverviewRequest
 * description:
 *
 * @author yumengjie
 * @date 2020/3/26 14:55
 */
@Data
public class NetworkOverviewRequest {
    @ApiModelProperty(value = "网络类型(GSM OR LTE)")
    private String networkType;
    @ApiModelProperty(value = "查询时间")
    private String scanStartTime;
}