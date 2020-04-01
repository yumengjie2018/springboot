package com.boco.jlappservice.entity.response;

import com.boco.jlappservice.entity.domainModel.CellPara;
import lombok.Data;

import java.util.ArrayList;

/**
 * title：GetCellParaResponse
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 18:42
 */
@Data
public class GetCellParaResponse {

    private ArrayList<CellPara> cellParaList;
}