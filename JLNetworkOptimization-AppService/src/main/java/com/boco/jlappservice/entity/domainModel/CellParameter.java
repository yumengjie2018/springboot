package com.boco.jlappservice.entity.domainModel;

import com.boco.jlappservice.enums.NEGranularity;
import lombok.Data;

/**
 * title：CellParameter
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 16:26
 */
@Data
public class CellParameter {

    private Long Id;
    private String ZhName;
    private String EnName;
    private String KPIValue;
    private Boolean IsRelatedOtherKPI;
    private NEGranularity RelatedNeType;

}