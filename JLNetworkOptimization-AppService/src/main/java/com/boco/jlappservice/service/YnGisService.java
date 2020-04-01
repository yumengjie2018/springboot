package com.boco.jlappservice.service;

import com.boco.jlappservice.entity.domainModel.GisCellsList;
import com.boco.jlappservice.entity.request.GetAdjacentCellRequest;
import com.boco.jlappservice.entity.request.GetCellsByIdRequest;
import com.boco.jlappservice.entity.request.GetGeoCellsByRegionRequest;
import com.boco.jlappservice.entity.response.ArrayCommonResponse;
import com.boco.jlappservice.entity.response.GetGeoCellsByRegionResponse;

public interface YnGisService {
    ArrayCommonResponse<GisCellsList> GetCellsList(GetCellsByIdRequest request);

    GetGeoCellsByRegionResponse GetGeoCellsByRegion(GetGeoCellsByRegionRequest request);

    GetGeoCellsByRegionResponse GetAdjacentResources(GetAdjacentCellRequest request);
}
