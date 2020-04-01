package com.boco.jlappservice.mapper;

import com.boco.jlappservice.entity.domainModel.AppGeoCell;
import com.boco.jlappservice.entity.domainModel.GisCellsList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * title：YnGisMapper
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 19:54
 */

public interface YnGisMapper {


    ArrayList<GisCellsList> GetCellsList(HashMap<String,Object> map);

    ArrayList<AppGeoCell> GetGeoCellByLonLat(HashMap<String,Object> map);

    ArrayList<AppGeoCell> GetAdjacentResources(HashMap<String,Object> map);
}