package com.boco.jlappservice.entity.domainModel;

/**
 * title：StructureIndex
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 17:11
 */

public class StructureIndex {

    public StructureIndex(Long id, String zhName, String enName,
                          String Value) {
        super();
        Id = id;
        ZhName = zhName;
        EnName = enName;
        this.Value = Value;
    }

    /**
     *
     */
    private static final long serialVersionUID = 6181055606344562296L;

    public StructureIndex() {
        super();
    }

    private Long Id;// ��� Long
    private String ZhName;// �������� String
    private String EnName;// Ӣ������ String
    private String Value;// �ṹָ��ֵ Double

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

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

}
