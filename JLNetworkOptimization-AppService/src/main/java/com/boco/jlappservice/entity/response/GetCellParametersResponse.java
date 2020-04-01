package com.boco.jlappservice.entity.response;

import com.boco.jlappservice.entity.domainModel.CellParameter;
import lombok.Data;

import java.util.ArrayList;

/**
 * title：GetCellParametersResponse
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 16:23
 */
@Data
public class GetCellParametersResponse {

    private ArrayList<CellParameter> cellParameterList;
}