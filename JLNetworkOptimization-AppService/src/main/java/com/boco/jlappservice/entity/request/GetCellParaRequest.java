package com.boco.jlappservice.entity.request;

import com.boco.jlappservice.enums.NEGranularity;
import com.boco.jlappservice.enums.NETechnology;
import lombok.Data;

/**
 * title：GetCellParaRequest
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 18:42
 */
@Data
public class GetCellParaRequest {

    private NETechnology neTechnology;
    private String id;
    private NEGranularity neGranularity;
}