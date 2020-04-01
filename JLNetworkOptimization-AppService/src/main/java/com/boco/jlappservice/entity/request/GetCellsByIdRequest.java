package com.boco.jlappservice.entity.request;

import com.boco.jlappservice.enums.NEGranularity;
import com.boco.jlappservice.enums.NETechnology;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：GetCellsByIdRequest
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 19:51
 */
@Data
public class GetCellsByIdRequest {

    @ApiModelProperty(value = "网元编号集合")
    private String ids;
    private NETechnology ne;
    private NEGranularity netype;

}