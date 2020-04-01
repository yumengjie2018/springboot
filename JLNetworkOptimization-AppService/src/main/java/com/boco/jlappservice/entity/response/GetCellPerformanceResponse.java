package com.boco.jlappservice.entity.response;

import com.boco.jlappservice.entity.domainModel.CellPerformance;
import lombok.Data;

import java.util.ArrayList;

/**
 * title：GetCellPerformanceResponse
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 17:39
 */
@Data
public class GetCellPerformanceResponse {

    private ArrayList<CellPerformance> cellPerformanceList;
}