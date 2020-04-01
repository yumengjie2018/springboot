package com.boco.jlappservice.entity.domainModel;

import lombok.Data;

/**
 * title：DetailInformationEntity
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 20:11
 */
@Data
public class DetailInformationEntity {

    private String ID;
    private String kpiName;
    private String kpiValue;
    private int sort;
    private int flag;//0:服务小区；1:邻区
}