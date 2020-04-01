package com.boco.jlappservice.entity.domainModel;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * title：BaseInformationEntity
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 20:10
 */
@Data
public class BaseInformationEntity {

    private String ID;
    private String userName;
    private String workID;
    private String insertDate;
    private String systemVersion;
    private String model;
    // private String networkType;
    private String simOperator;
    // private String simSerialNumber;
    private String IMEI;
    private String IMSI;
    private String latitude;
    private String longitude;
    private String locationProvider;
    private String accuracyRadius;
    public String detailListS="[]";
    private List<DetailInformationEntity> detailList = new ArrayList<DetailInformationEntity>();
}