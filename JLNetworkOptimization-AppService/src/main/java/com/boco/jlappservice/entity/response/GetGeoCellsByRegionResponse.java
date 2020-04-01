package com.boco.jlappservice.entity.response;

import com.boco.jlappservice.entity.domainModel.AppGeoCell;
import lombok.Data;

import java.util.ArrayList;

/**
 * title：GetGeoCellsByRegionResponse
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 20:34
 */
@Data
public class GetGeoCellsByRegionResponse {

    private ArrayList<AppGeoCell> GeoCellList;
}