package com.boco.jlappservice.entity.request;

import com.boco.jlappservice.enums.NEGranularity;
import com.boco.jlappservice.enums.NETechnology;
import com.boco.jlappservice.enums.SumLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * title：GetCellPerformanceRequest
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 17:40
 */
@Data
public class GetCellPerformanceRequest {

    @ApiModelProperty(value = "网元制式")
    private NETechnology neTechnology;// NETechnology

    @ApiModelProperty(value = "网优编号")
    private String id;

    @ApiModelProperty(value = "汇总粒度")
    private SumLevel sumLevel;

    @ApiModelProperty(value = "时间戳")
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String scanStartTime;

    private NEGranularity neGranularity;
}