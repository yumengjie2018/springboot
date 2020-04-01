package com.boco.jlappservice.entity.response;

import com.boco.jlappservice.entity.domainModel.Cell;
import lombok.Data;

import java.util.ArrayList;

/**
 * title：GetCellsByNameResponse
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 19:14
 */
@Data
public class GetCellsByNameResponse {

    private Integer totalRecord;
    private Integer totalPage;
    private Integer pageSize;
    private Integer currentPage;
    private ArrayList<Cell> cellList;

}