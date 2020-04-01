package com.boco.jlappservice.entity.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：UserByGroupResponse
 * description:根据组获取用户
 *
 * @author yumengjie
 * @date 2019/7/29 16:29
 */
@Data
public class UserByGroupResponse {
    @ApiModelProperty(value = "用户id")
    private String id;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "")
    private String displayName;
    @ApiModelProperty(value = "地市id")
    private String regionID;
    @ApiModelProperty(value = "地市名称")
    private String regionName;
    @ApiModelProperty(value = "部门id")
    private String departmentID;
    @ApiModelProperty(value = "部门名称")
    private String departmentName;
    @ApiModelProperty(value = "电话")
    private String phoneNo;
}