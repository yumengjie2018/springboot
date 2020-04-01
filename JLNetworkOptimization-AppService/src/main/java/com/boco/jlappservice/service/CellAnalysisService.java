package com.boco.jlappservice.service;

import com.boco.jlappservice.entity.request.*;
import com.boco.jlappservice.entity.response.*;

import java.util.ArrayList;

/**
 * title：CellAnalysisService
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 16:14
 */

public interface CellAnalysisService {

    GetCellParametersResponse getPlanResource(GetCellParametersRequest request);

    GetCellParametersResponse GetCellParameters(GetCellParametersRequest request);

    GetCellPerformanceResponse GetCellPerformance(GetCellPerformanceRequest request);

    GetCellParaResponse GetCellPara(GetCellParaRequest request);

    GetAdjacentCellResponse GetAdjacentCell(GetAdjacentCellRequest request);

    GetCellAlarmResponse GetCellAlarm(GetCellAlarmRequest request);

    GetCellsByNameResponse GetCellsByName(GetCellsByNameRequest request);

    GetGeoCellsByRegionResponse GetResourceIdByCgi(String cgi);

    ArrayList<CellAnalysisResponse> GetCellAnalysis(CellAnalysisRequest request);
}