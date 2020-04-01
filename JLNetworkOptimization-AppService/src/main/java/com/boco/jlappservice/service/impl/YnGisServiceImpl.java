package com.boco.jlappservice.service.impl;

import com.boco.jlappservice.entity.domainModel.AppGeoCell;
import com.boco.jlappservice.entity.domainModel.GeoCell;
import com.boco.jlappservice.entity.domainModel.GisCellsList;
import com.boco.jlappservice.entity.request.GetAdjacentCellRequest;
import com.boco.jlappservice.entity.request.GetCellsByIdRequest;
import com.boco.jlappservice.entity.request.GetGeoCellsByRegionRequest;
import com.boco.jlappservice.entity.response.ArrayCommonResponse;
import com.boco.jlappservice.entity.response.GetGeoCellsByRegionResponse;
import com.boco.jlappservice.enums.NETechnology;
import com.boco.jlappservice.mapper.YnGisMapper;
import com.boco.jlappservice.service.YnGisService;
import com.boco.jlappservice.utility.DateUtils;
import com.boco.jlappservice.utility.GpsCoordinateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * title：YnGisServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 19:53
 */
@Service
public class YnGisServiceImpl implements YnGisService {
    @Autowired
    private YnGisMapper mapper;
    @Override
    public ArrayCommonResponse<GisCellsList> GetCellsList(GetCellsByIdRequest request) {
        ArrayCommonResponse<GisCellsList> response = new ArrayCommonResponse<>();
        HashMap<String, Object> map = new HashMap<>();
        String scanStartTime = DateUtils.getUserDate("yyyy-MM-dd 00:00:00");
        scanStartTime = DateUtils.getNextDay(scanStartTime, "-1", null);
        map.put("scan_start_time", scanStartTime);
        map.put("intId", request.getIds());
        map.put("technology", request.getNe().getValue());
        ArrayList<GisCellsList> result = mapper.GetCellsList(map);
        if(result==null || result.size()==0){
            result=new ArrayList<>();
        }
        else {
            for (GisCellsList gisCellsList:result) {
                HashMap<String,Object> baidu=GpsCoordinateUtils.calWGS84toBD09(gisCellsList.getBaiduLatitude(),gisCellsList.getBaiduLongitude());
                gisCellsList.setBaiduLatitude((Double) baidu.get("retLat"));
                gisCellsList.setBaiduLongitude((Double) baidu.get("retLon"));
            }
        }
        response.setResultAll(result);
        return response;
    }

    @Override
    public GetGeoCellsByRegionResponse GetGeoCellsByRegion(GetGeoCellsByRegionRequest request) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        GetGeoCellsByRegionResponse response = new GetGeoCellsByRegionResponse();
        ArrayList<Integer> nes = new ArrayList<Integer>();
        ArrayList<String> neNames = new ArrayList<String>();
        for (NETechnology ne : request.getNeTechnology()) {
            nes.add(ne.getValue());
            neNames.add(ne.name());
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("nes", nes);
        map.put("neNames", neNames);
        map.put("maxLon", request.getMaxLon());
        map.put("minLon", request.getMinLon());
        map.put("maxLat", request.getMaxLat());
        map.put("minLat", request.getMinLat());
        ArrayList<AppGeoCell> result = mapper.GetGeoCellByLonLat(map);
        if(result==null || result.size()==0){
            result=new ArrayList<>();
        }
        else {
            latLonToBaiduLatLon(result);
        }
        response.setGeoCellList(result);
        return response;
    }

    @Override
    public GetGeoCellsByRegionResponse GetAdjacentResources(GetAdjacentCellRequest request) {
        GetGeoCellsByRegionResponse response = new GetGeoCellsByRegionResponse();
        HashMap<String, Object> map = new HashMap<>();
        map.put("ne", request.getNeTechnology().getValue());
        map.put("idNo", request.getId());
        ArrayList<Integer> adjacents = new ArrayList<>();
        adjacents.add(1);
        adjacents.add(8);
        if (adjacents.size() == 0)
            adjacents = null;
        map.put("adjacents", adjacents);
        ArrayList<AppGeoCell> result = mapper.GetAdjacentResources(map);
        if(result == null || result.size() == 0){
            result = new ArrayList<>();
        }else {
            latLonToBaiduLatLon(result);
        }
        response.setGeoCellList(result);
        return response;
    }
    //经纬度转换百度经纬度
    private void latLonToBaiduLatLon(ArrayList<AppGeoCell> result) {
        for (AppGeoCell appGeoCell:result) {
            HashMap<String,Object> baidu=GpsCoordinateUtils.calWGS84toBD09(appGeoCell.getBaiduLatitude(),appGeoCell.getBaiduLongitude());
            appGeoCell.setBaiduLatitude((Double) baidu.get("retLat"));
            appGeoCell.setBaiduLongitude((Double) baidu.get("retLon"));
        }
    }
}