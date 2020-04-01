package com.boco.jlappservice.entity.domainModel;

import com.boco.jlappservice.enums.NEGranularity;
import lombok.Data;

/**
 * title：RnopMnoParameter
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 16:36
 */
@Data
public class RnopMnoParameter {
    private long id;
    private String tableName;
    private String filedName;
    private String zhName;
    private Boolean IsRelatedOtherKPI;
    private NEGranularity neGranularity;
    private int IsPercent;
    private int fieldIsSql;
}