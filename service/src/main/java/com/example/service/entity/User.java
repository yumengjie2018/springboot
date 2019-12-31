package com.example.service.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user_test")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @Column(name = "user_name")
    @ApiModelProperty(value = "用户名")
    private String userName;
    @Column(name = "age")
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @Column(name = "address")
    @ApiModelProperty(value = "地址")
    private String address;
    @Column(name = "email")
    @ApiModelProperty(value = "邮件")
    private String email;

}
