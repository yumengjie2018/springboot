package com.boco.jlappservice.mapper;

import com.boco.jlappservice.entity.domainModel.*;
import com.boco.jlappservice.entity.request.CellAnalysisRequest;
import com.boco.jlappservice.entity.response.CellAnalysisResponse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * title：CellAnalysisMapper
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 16:15
 */

public interface CellAnalysisMapper {


    ArrayList<RnopMnoParameter> GetRnopMnoParameters(HashMap<String,Object> map);

    HashMap<String,Object> GetAnalysisParameter(HashMap<String,Object> mapTableField);

    int GetRelatedCount(HashMap<String, Object> enodeIdMap);

    String GetCellPerformanceMaxScanStartTime(HashMap<String,Object> map);

    TempPerformanceEntity GetCellPerformances(HashMap<String,Object> maps);

    Double getMrCover(HashMap<String, Object> maps);

    Long GetParaVendor(HashMap<String,Object> mapVendor);

    ArrayList<GeoCell> GetAdjacentCell(HashMap<String,Object> map);

    ArrayList<CellAlarm> GetCellAlarm(HashMap<String,Object> map);

    ArrayList<Cell> GetCellByName(HashMap<String,Object> map);

    ArrayList<AppGeoCell> GetResourceIdByCgi(HashMap<String,Object> map);

    ArrayList<CellAnalysisResponse> GetCellAnalysis(CellAnalysisRequest request);
}