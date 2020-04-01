package com.boco.jlappservice.entity.domainModel;

/**
 * title：LTEParameterValue
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 17:12
 */

public class LTEParameterValue {
    public LTEParameterValue(Long id, String zhName, String Value) {
        super();
        Id = id;
        ZhName = zhName;
        this.Value = Value;
    }

    /**
     *
     */
    private static final long serialVersionUID = 6181055606344562296L;

    public LTEParameterValue() {
        super();
    }

    private Long Id;// ��� Long
    private String ZhName;// �������� String
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

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

}
