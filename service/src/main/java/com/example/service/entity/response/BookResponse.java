package com.example.service.entity.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：BookResponse
 * description:
 *
 * @author yumengjie
 * @date 2019/2/18 9:25
 */
@Data
public class BookResponse {
    @ApiModelProperty(value = "书名")
    private String bookName;
    @ApiModelProperty("价格")
    private String price;
    private int years;
}