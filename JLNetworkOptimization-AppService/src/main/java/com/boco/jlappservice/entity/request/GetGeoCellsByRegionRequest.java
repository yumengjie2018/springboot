package com.boco.jlappservice.entity.request;

import com.boco.jlappservice.enums.NETechnology;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;

/**
 * title：GetGeoCellsByRegionRequest
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 20:37
 */
@Data
public class GetGeoCellsByRegionRequest {


    @ApiModelProperty(value = "制式集合")
    private ArrayList<NETechnology> neTechnology;

    @ApiModelProperty(value = "最大经度")
    private double maxLon;

    @ApiModelProperty(value = "最小经度")
    private double minLon;

    @ApiModelProperty(value = "最大纬度")
    private double maxLat;

    @ApiModelProperty(value = "最小纬度")
    private double minLat;
}