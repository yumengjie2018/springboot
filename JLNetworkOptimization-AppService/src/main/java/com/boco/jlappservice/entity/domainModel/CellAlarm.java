package com.boco.jlappservice.entity.domainModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：CellAlarm
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 19:04
 */
@Data
public class CellAlarm {
    private long id;
    private String oid;
    private String alarmTitle;
    private String alarmContent;
    private String alarmTime;
    private String alarmLevel;
}