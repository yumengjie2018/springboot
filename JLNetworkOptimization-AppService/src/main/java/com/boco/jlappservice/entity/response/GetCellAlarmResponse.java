package com.boco.jlappservice.entity.response;

import com.boco.jlappservice.entity.domainModel.CellAlarm;
import lombok.Data;

import java.util.ArrayList;

/**
 * title：GetCellAlarmResponse
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 19:03
 */
@Data
public class GetCellAlarmResponse {

    private ArrayList<CellAlarm> cellAlarmList;
}