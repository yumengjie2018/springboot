package com.boco.jlappservice.entity.domainModel;

import com.boco.jlappservice.enums.NEGranularity;

/**
 * title：RnopMnoKpi
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 17:13
 */

public class RnopMnoKpi {

    public RnopMnoKpi(long id, String tableName, String filedName,
                      String zhName, Boolean isRelatedOtherKPI,
                      NEGranularity neGranularity, int isPercent, int fieldIsSql) {
        super();
        this.id = id;
        this.tableName = tableName;
        this.filedName = filedName;
        this.zhName = zhName;
        IsRelatedOtherKPI = isRelatedOtherKPI;
        this.neGranularity = neGranularity;
        IsPercent = isPercent;
        this.fieldIsSql = fieldIsSql;
    }

    public RnopMnoKpi() {
        super();
    }

    private long id;
    private String tableName;
    private String filedName;
    private String zhName;
    private Boolean IsRelatedOtherKPI;// Boolean ��ʶ����ֶ��Ƿ���Խ��й����鿴��������
    private NEGranularity neGranularity;// ����ָ����
    private int IsPercent;
    private int fieldIsSql;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public Boolean getIsRelatedOtherKPI() {
        return IsRelatedOtherKPI;
    }

    public void setIsRelatedOtherKPI(Boolean isRelatedOtherKPI) {
        IsRelatedOtherKPI = isRelatedOtherKPI;
    }

    public NEGranularity getNeGranularity() {
        return neGranularity;
    }

    public void setNeGranularity(NEGranularity neGranularity) {
        this.neGranularity = neGranularity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the isPercent
     */
    public int getIsPercent() {
        return IsPercent;
    }

    /**
     * @param isPercent
     *            the isPercent to set
     */
    public void setIsPercent(int isPercent) {
        IsPercent = isPercent;
    }

    /**
     * @return the fieldIsSql
     */
    public int getFieldIsSql() {
        return fieldIsSql;
    }

    /**
     * @param fieldIsSql the fieldIsSql to set
     */
    public void setFieldIsSql(int fieldIsSql) {
        this.fieldIsSql = fieldIsSql;
    }
}
