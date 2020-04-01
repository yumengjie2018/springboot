package com.boco.jlappservice.entity.response;

import com.boco.jlappservice.entity.domainModel.GeoCell;
import lombok.Data;

import java.util.ArrayList;

/**
 * title：GetAdjacentCellResponse
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 18:48
 */
@Data
public class GetAdjacentCellResponse {

    public ArrayList<GeoCell> adjacentList;
}