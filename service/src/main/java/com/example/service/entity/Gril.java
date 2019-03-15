package com.example.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * title：Gril
 * description:
 *
 * @author yumengjie
 * @date 2018/12/28 15:33
 */
@Data
@Entity
public class Gril {
    @Id
    private Long id;
    @Min(value = 18,message = "未成年")
    @Column(name = "age",nullable = true,length = 4)
    private Integer age;
    @Column(name = "num_size",nullable = true,length = 20)
    private String size;
    @Column(name = "address",nullable = true,length = 50)
    private String address;
}