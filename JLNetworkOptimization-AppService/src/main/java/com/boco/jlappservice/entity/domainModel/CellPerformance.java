package com.boco.jlappservice.entity.domainModel;

import com.boco.jlappservice.enums.NEGranularity;
import com.boco.jlappservice.enums.SumLevel;

import java.util.Date;

/**
 * title：CellPerformance
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 17:05
 */

public class CellPerformance {
    public CellPerformance(Long id, String zhName, String enName,
                           String performanceValue, Date scanStartTime, NEGranularity neType,
                           SumLevel sumLevel) {
        super();
        Id = id;
        ZhName = zhName;
        EnName = enName;
        PerformanceValue = performanceValue;
        this.scanStartTime = scanStartTime;
        NeType = neType;
        this.sumLevel = sumLevel;
    }

    public CellPerformance() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Long Id;
    private String ZhName;
    private String EnName;
    private String PerformanceValue;
    private Date scanStartTime;
    private NEGranularity NeType;
    private SumLevel sumLevel;

    public Date getScanStartTime() {
        return scanStartTime;
    }

    public void setScanStartTime(Date scanStartTime) {
        this.scanStartTime = scanStartTime;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getZhName() {
        return ZhName;
    }

    public void setZhName(String zhName) {
        ZhName = zhName;
    }

    public String getEnName() {
        return EnName;
    }

    public void setEnName(String enName) {
        EnName = enName;
    }

    public String getPerformanceValue() {
        return PerformanceValue;
    }

    public void setPerformanceValue(String performanceValue) {
        PerformanceValue = performanceValue;
    }

    public NEGranularity getNeType() {
        return NeType;
    }

    public void setNeType(NEGranularity neType) {
        NeType = neType;
    }

    public SumLevel getSumLevel() {
        return sumLevel;
    }

    public void setSumLevel(SumLevel sumLevel) {
        this.sumLevel = sumLevel;
    }

}
