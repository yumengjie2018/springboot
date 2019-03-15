package com.boco.hnappservice.entity.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * title：UserResponseEntity
 * description:
 *
 * @author yumengjie
 * @date 2019/3/14 10:13
 */
@Data
public class UserResponseEntity implements Serializable {
    private static final long serialVersionUID = -6046201557090785433L;

    @ApiModelProperty("用户唯一ID")
    private String userId="";
    @ApiModelProperty("登陆的用户名")
    private String userName="";
    @ApiModelProperty("显示名")
    private String displayName="";
    @ApiModelProperty("邮箱")
    private String userMail="";
    @ApiModelProperty("电话")
    private String userPhone="";

    @ApiModelProperty("组名")
    private String groupName="";
    @ApiModelProperty("公司名")
    private String companyName="";

    @ApiModelProperty("用户权限 0(管理员)，1（用户）")
    private int userAuthority;
    @ApiModelProperty("用户角色0(高端用户)，1（中端用户），2（低端用户）")
    private int userRole;
    @ApiModelProperty("用户头像链接")
    private String userAvatar="";
    @ApiModelProperty("用户授权码")
    private String token="";
    @ApiModelProperty("人脸识别图片")
    private String faceIdUrl="";

    @ApiModelProperty("加密后的时间戳")
    private String timeSpan;
    @ApiModelProperty("redis记录用户登陆次数")
    private String num="";
}