package com.boco.jlappservice.service.impl;

import com.boco.jlappservice.entity.domainModel.*;
import com.boco.jlappservice.entity.request.*;
import com.boco.jlappservice.entity.response.*;
import com.boco.jlappservice.enums.NEGranularity;
import com.boco.jlappservice.enums.NETechnology;
import com.boco.jlappservice.enums.ParameterType;
import com.boco.jlappservice.enums.SumLevel;
import com.boco.jlappservice.mapper.CellAnalysisMapper;
import com.boco.jlappservice.service.CellAnalysisService;
import com.boco.jlappservice.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * title：CellAnalysisServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 16:14
 */
@Service
public class CellAnalysisServiceImpl implements CellAnalysisService{
    @Autowired
    private CellAnalysisMapper mapper;

    private static AnalysisParameterUtil util = null;

    private CellAnalysisServiceImpl() {
        util = new AnalysisParameterUtil();
    }

    @Override
    public GetCellParametersResponse getPlanResource(GetCellParametersRequest request) {
        GetCellParametersResponse response = new GetCellParametersResponse();
        NETechnology ne = request.getNeTechnology();
        String id = request.getId();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("parameterType", ParameterType.tcoparameter.getValue());
        map.put("netype", 0);
        map.put("ne", ne.getValue());
        ArrayList<RnopMnoParameter> listRnopMnoParameter = mapper.GetRnopMnoParameters(map);
        ArrayList<CellParameter> result = new ArrayList<CellParameter>();
        if (listRnopMnoParameter.size() > 0) {
            HashMap<String, Object> mapTableField = util.GetTableFieldPlan(ne, id, listRnopMnoParameter);
            HashMap<String, Object> mapResultParameter = mapper.GetAnalysisParameter(mapTableField);
            if (mapResultParameter != null) {
                String cellParameterStr = mapResultParameter.toString();
                System.out.println(cellParameterStr);
                if (cellParameterStr.length() > 10) {
                    cellParameterStr = cellParameterStr.substring(1, cellParameterStr.length() - 1);
                    result = util.setCellParameterList(listRnopMnoParameter, cellParameterStr);
                }
            }
        }
        //2018-1-11 需求：规划图层设计阶段详情里面增加 “是否已落地”字段.理想情况下应该在数据库表中增加这个字段
        //按照ID判断当前字符失败，所以按照中文字来判断
        if (ne == NETechnology.PLANDG) {
            CellParameter isLoadedCellParameter = new CellParameter();
            isLoadedCellParameter.setZhName("是否已落地");
            //取出ENODEB_ID
            String enodeId="";
            for (CellParameter cellParameter : result) {
                if (cellParameter.getZhName().equals("ENODEN_ID(根据各分公司号段划分)")) {
                    enodeId = cellParameter.getKPIValue();
                    break;
                }
            }
            HashMap<String, Object> enodeIdMap = new HashMap<String, Object>();
            enodeIdMap.put("enodebId", enodeId);
            int count = 0;
            count=mapper.GetRelatedCount(enodeIdMap);
            String resultDesc = count>0?"已落地":"未落地";
            isLoadedCellParameter.setKPIValue(resultDesc);
            isLoadedCellParameter.setRelatedNeType(NEGranularity.Cell);
            isLoadedCellParameter.setEnName("isLoaded");
            isLoadedCellParameter.setIsRelatedOtherKPI(false);
            result.add(isLoadedCellParameter);
        }
        response.setCellParameterList(result);
        return response;
    }

    @Override
    public GetCellParametersResponse GetCellParameters(GetCellParametersRequest request) {
        GetCellParametersResponse response = new GetCellParametersResponse();
        NETechnology ne = request.getNeTechnology();
        NEGranularity netype = request.getNeGranularity();
        String id = request.getId();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("parameterType", ParameterType.tcoparameter.getValue());
        map.put("netype", netype.getValue());
        map.put("ne", ne.getValue());
        ArrayList<RnopMnoParameter> listRnopMnoParameter = mapper.GetRnopMnoParameters(map);
        ArrayList<CellParameter> result = new ArrayList<CellParameter>();
        if (listRnopMnoParameter.size() > 0) {
            HashMap<String, Object> mapTableField = util.GetTableFieldString5(ne, netype, ParameterType.tcoparameter,
                    null, null, id, listRnopMnoParameter);
            HashMap<String, Object> mapResultParameter = mapper.GetAnalysisParameter(mapTableField);
            if (mapResultParameter != null) {
                String cellParameterStr = mapResultParameter.toString();
                System.out.println(cellParameterStr);
                if (cellParameterStr.length() > 10) {
                    cellParameterStr = cellParameterStr.substring(1, cellParameterStr.length() - 1);
                    result = util.setCellParameterList(listRnopMnoParameter, cellParameterStr);
                }
            }
        }
        response.setCellParameterList(result);
        return response;
    }

    @Override
    public GetCellPerformanceResponse GetCellPerformance(GetCellPerformanceRequest request) {
        GetCellPerformanceResponse response = new GetCellPerformanceResponse();
        NETechnology ne = request.getNeTechnology();
        NEGranularity netype = request.getNeGranularity();
        String id = request.getId();
        SumLevel sumLevel = request.getSumLevel();
        ArrayList<CellPerformance> result = null;
        String datescanStartTime = null;
        String scanStartTime = null;
        if (request.getScanStartTime() == null) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("netype", netype.getValue());
            map.put("ne", ne.getValue());
            map.put("sumLevel", sumLevel.getValue());
            datescanStartTime = mapper.GetCellPerformanceMaxScanStartTime(map);
            scanStartTime = "to_date('" + datescanStartTime + "','yyyy-mm-dd hh24:mi:ss')";
        } else {
                datescanStartTime = VeDate.dateToStr(VeDate.strToDate(request.getScanStartTime()));
                scanStartTime = "to_date('" + datescanStartTime + "','YYYY-MM-DD')";
        }
        if (datescanStartTime == null) {
            if (SumLevel.Hour.equals(request.getSumLevel())) {
                datescanStartTime = VeDate.dateToStrLong(VeDate.getNow());
                scanStartTime = "to_date('" + datescanStartTime + "','YYYY-MM-DD hh24:mi:ss')";
            } else {
                datescanStartTime = VeDate.dateToStr(VeDate.getNow());
                scanStartTime = "to_date('" + datescanStartTime + "','YYYY-MM-DD')";
            }
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("parameterType", ParameterType.performance.getValue());
        map.put("netype", netype.getValue());
        map.put("ne", ne.getValue());
        ArrayList<RnopMnoParameter> listRnopMnoParameter = mapper.GetRnopMnoParameters(map);
        if (listRnopMnoParameter.size() > 0) {
            HashMap<String, Object> mapPerformance = util.GetTableFieldString(ne, netype, ParameterType.performance,
                    scanStartTime, sumLevel, id, listRnopMnoParameter);
            HashMap<String, Object> mapResultPerformance = mapper.GetAnalysisParameter(mapPerformance);
            if (mapResultPerformance != null) {
                String cellPerformanceStr = mapResultPerformance.toString();
                System.out.println(cellPerformanceStr);
                if (cellPerformanceStr.length() > 10) {
                    cellPerformanceStr = cellPerformanceStr.substring(1, cellPerformanceStr.length() - 1);
                    result = util.setCellPerformanceList(scanStartTime, listRnopMnoParameter, cellPerformanceStr);
                }
            }
        }
        //新加性能指标
        TempPerformanceEntity entity = new TempPerformanceEntity();
        HashMap<String, Object> maps = new HashMap<String, Object>();
        maps.put("neType", netype.getValue());
        maps.put("sumLevel", sumLevel.getValue());
        maps.put("cellId", request.getId());
        maps.put("scanTime", scanStartTime);
        entity = mapper.GetCellPerformances(maps);
        Double mrCover =mapper.getMrCover(maps);
        Long lon;
        NEGranularity Temp;
        SumLevel Tem;
        String neName;
        Date date = null;
        if(entity != null) {
            if(result != null) {
                lon = Long.valueOf(request.getId());
                Temp = result.get(0).getNeType();
                Tem = result.get(0).getSumLevel();
                neName = result.get(0).getEnName();
            }else {
                lon = (long)0;
                Temp = NEGranularity.Temp;
                Tem = SumLevel.Tem;
                neName = " ";
                result = new ArrayList<CellPerformance>();
            }
            result.add(new CellPerformance(lon,"有效RRC连接最大数",neName,String.valueOf(entity.getRrcNum()),date,Temp,Tem));
            result.add(new CellPerformance(lon,"上行PRB平均利用率",neName,String.valueOf(entity.getUpPrb()),date,Temp,Tem));
            result.add(new CellPerformance(lon,"下行PRB平均利用率",neName,String.valueOf(entity.getDownPrb()),date,Temp,Tem));
            result.add(new CellPerformance(lon,"volte语音话务量",neName,String.valueOf(entity.getVolteNum()),date,Temp,Tem));
            result.add(new CellPerformance(lon,"volte上行丢包率",neName,String.valueOf(entity.getVolteLose()),date,Temp,Tem));
            result.add(new CellPerformance(lon,"esrvcc呼叫切换比",neName,String.valueOf(entity.getEsrvcc()),date,Temp,Tem));
        }
        if(mrCover!=null){
            if(result != null) {
                lon = Long.valueOf(request.getId());
                Temp = result.get(0).getNeType();
                Tem = result.get(0).getSumLevel();
                neName = result.get(0).getEnName();
            }else {
                lon = (long)0;
                Temp = NEGranularity.Temp;
                Tem = SumLevel.Tem;
                neName = " ";
                result = new ArrayList<CellPerformance>();
            }
            result.add(new CellPerformance(lon,"MR覆盖率",neName,String.valueOf(mrCover),date,Temp,Tem));
        }
        response.setCellPerformanceList(result);
        return response;
    }

    @Override
    public GetCellParaResponse GetCellPara(GetCellParaRequest request) {
        GetCellParaResponse response = new GetCellParaResponse();
        NEGranularity netype = request.getNeGranularity();
        NETechnology ne = request.getNeTechnology();
        String idNo = request.getId();
        HashMap<String, Object> mapVendor = new HashMap<String, Object>();
        mapVendor.put("ne", ne.getValue());
        mapVendor.put("idNo", idNo);
        Long vendorId = mapper.GetParaVendor(mapVendor);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("parameterType", ParameterType.para.getValue());
        map.put("netype", netype.getValue());
        map.put("ne", ne.getValue());
        map.put("vendorId", vendorId);
        ArrayList<RnopMnoParameter> listRnopMnoParameter = mapper.GetRnopMnoParameters(map);
        ArrayList<CellPara> result = null;
        if (listRnopMnoParameter.size() > 0) {
            HashMap<String, Object> mapTableField = util.GetTableFieldString(ne, netype, ParameterType.para, null, null,
                    idNo, listRnopMnoParameter);
            HashMap<String, Object> mapResultPara = mapper.GetAnalysisParameter(mapTableField);
            if (mapResultPara != null) {
                String cellParaStr = mapResultPara.toString();
                if (cellParaStr.length() > 10) {
                    cellParaStr = cellParaStr.substring(1, cellParaStr.length() - 1);
                    result = util.setCellParaList(listRnopMnoParameter, cellParaStr);
                }
            }
        }
        response.setCellParaList(result);
        return response;
    }

    @Override
    public GetAdjacentCellResponse GetAdjacentCell(GetAdjacentCellRequest request) {
        GetAdjacentCellResponse response = new GetAdjacentCellResponse();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("ne", request.getNeTechnology().getValue());
        String idStr=request.getId();
        map.put("idNo",  idStr);
        ArrayList<Integer> adjacents = new ArrayList<Integer>();
        for (NETechnology ne : request.getnETechnologys()) {
            adjacents.add(ne.getValue());
        }
        if (adjacents.size() == 0)
            adjacents = null;
        map.put("adjacents", adjacents);
        ArrayList<GeoCell> result = mapper.GetAdjacentCell(map);
        if (result == null && result.size() == 0) {
            result = new ArrayList<>();
        }else {
            for (GeoCell geoCell:result) {
                HashMap<String,Object> baidu=GpsCoordinateUtils.calWGS84toBD09(geoCell.getBaiduLatitude(),geoCell.getBaiduLongitude());
                geoCell.setBaiduLatitude((Double) baidu.get("retLat"));
                geoCell.setBaiduLongitude((Double) baidu.get("retLon"));
            }
        }
        response.setAdjacentList(result);
        return response;
    }

    @Override
    public GetCellAlarmResponse GetCellAlarm( GetCellAlarmRequest request) {
        GetCellAlarmResponse response = new GetCellAlarmResponse();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("ne", request.getNeTechnology().getValue());
        map.put("idNo", request.getId());
        map.put("netype", request.getNeGranularity());
        map.put("neTechnology", request.getNeTechnology().getValue());
        String format = "yyyy-MM-dd 00:00:00";
        String scanStartTime = DateUtils.getNextDay(DateUtils.getUserDate(format), "-2", format);
        map.put("scanStartTime", scanStartTime);
        ArrayList<CellAlarm> result = mapper.GetCellAlarm(map);
        response.setCellAlarmList(result);
        return response;
    }

    @Override
    public GetCellsByNameResponse GetCellsByName(GetCellsByNameRequest request) {
        GetCellsByNameResponse response = new GetCellsByNameResponse();
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("cellName", URLDecoder.decode(request.getCellName(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        map.put("ne", request.getNeTechnology().getValue());
        String format = "yyyy-MM-dd 00:00:00";
        String scanStartTime = DateUtils.getNextDay(DateUtils.getUserDate(format), "-1", format);
        map.put("scan_start_time", scanStartTime);
        ArrayList<Cell> result = mapper.GetCellByName(map);
        if (result != null) {
            response.setCellList(result);
        }
        return response;
    }

    @Override
    public GetGeoCellsByRegionResponse GetResourceIdByCgi(String cgi ) {
        GetGeoCellsByRegionResponse response = new GetGeoCellsByRegionResponse();
        HashMap<String, Object> map = new HashMap<>();
        map.put("cgi", cgi);
        ArrayList<AppGeoCell> result = mapper.GetResourceIdByCgi(map);
        if(result==null || result.size()==0){
            result=new ArrayList<>();
        }else {
            for (AppGeoCell appGeoCell:result) {
                HashMap<String,Object> baidu=GpsCoordinateUtils.calWGS84toBD09(appGeoCell.getBaiduLatitude(),appGeoCell.getBaiduLongitude());
                appGeoCell.setBaiduLatitude((Double) baidu.get("retLat"));
                appGeoCell.setBaiduLongitude((Double) baidu.get("retLon"));
            }
        }
        response.setGeoCellList(result);
        return response;
    }

    @Override
    public ArrayList<CellAnalysisResponse> GetCellAnalysis(CellAnalysisRequest request) {
        ArrayList<CellAnalysisResponse> responses=mapper.GetCellAnalysis(request);
        if(responses.size()>0){
            for (CellAnalysisResponse cellAnalysisResponse:responses) {
                HashMap<String,Object> baidu=GpsCoordinateUtils.calWGS84toBD09(cellAnalysisResponse.getBaiduLatitude(),cellAnalysisResponse.getBaiduLongitude());
                cellAnalysisResponse.setBaiduLatitude((Double) baidu.get("retLat"));
                cellAnalysisResponse.setBaiduLongitude((Double) baidu.get("retLon"));
            }
        }
        return responses;
    }
}