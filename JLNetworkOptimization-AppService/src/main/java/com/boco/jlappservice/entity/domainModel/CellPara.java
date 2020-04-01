package com.boco.jlappservice.entity.domainModel;

import com.boco.jlappservice.enums.NEGranularity;

/**
 * title：CellPara
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 17:04
 */

public class CellPara {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CellPara(Long id, String zhName, String enName, String kPIValue,
                    Boolean isRelatedOtherKPI, NEGranularity relatedNeType) {
        super();
        Id = id;
        ZhName = zhName;
        EnName = enName;
        KPIValue = kPIValue;
        IsRelatedOtherKPI = isRelatedOtherKPI;
        RelatedNeType = relatedNeType;
    }

    public CellPara() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Long Id;
    private String ZhName;
    private String EnName;
    private String KPIValue;
    private Boolean IsRelatedOtherKPI;
    private NEGranularity RelatedNeType;

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

    public String getKPIValue() {
        return KPIValue;
    }

    public void setKPIValue(String kPIValue) {
        KPIValue = kPIValue;
    }

    public Boolean getIsRelatedOtherKPI() {
        return IsRelatedOtherKPI;
    }

    public void setIsRelatedOtherKPI(Boolean isRelatedOtherKPI) {
        IsRelatedOtherKPI = isRelatedOtherKPI;
    }

    public NEGranularity getRelatedNeType() {
        return RelatedNeType;
    }

    public void setRelatedNeType(NEGranularity relatedNeType) {
        RelatedNeType = relatedNeType;
    }
}
