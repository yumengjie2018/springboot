package com.example.service.excel.excelDemo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：UserPhoneNumberEntity
 * description:
 *
 * @author yumengjie
 * @date 2019/12/3 10:53
 */
@Data
public class UserPhoneNumberEntity {

    @ApiModelProperty("电话号码")
    private long phoneNumber;
}