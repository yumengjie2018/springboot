package com.boco.jlappservice.entity.domainModel;

/**
 * title：GisCellsList
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 19:49
 */

public class GisCellsList {

    public GisCellsList() {
        super();
    }

    public String getIntId() {
        return intId;
    }
    public void setIntId(String intId) {
        this.intId = intId;
    }

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    public double getBaiduLongitude() {
        return BaiduLongitude;
    }

    public void setBaiduLongitude(double baiduLongitude) {
        BaiduLongitude = baiduLongitude;
    }

    public double getBaiduLatitude() {
        return BaiduLatitude;
    }

    public void setBaiduLatitude(double baiduLatitude) {
        BaiduLatitude = baiduLatitude;
    }

    public double getDir() {
        return Dir;
    }

    public void setDir(double dir) {
        Dir = dir;
    }

    public Integer getIndoorSupport() {
        return IndoorSupport;
    }

    public void setIndoorSupport(Integer indoorSupport) {
        IndoorSupport = indoorSupport;
    }

    public String getNETechnology() {
        return NETechnology;
    }

    public void setNETechnology(String nETechnology) {
        NETechnology = nETechnology;
    }

    public String getNeType() {
        if(this.NETechnology.equals("LTE")){
            return "Eutrancell";
        }
        else if(this.NETechnology.equals("TD")){
            return "UtranCell";
        }
        else if(this.NETechnology.equals("GSM")){
            return "Cell";
        }
        else{
            return "";
        }

    }

    public void setNeType(String neType) {
        NeType = neType;
    }

    /**
     *
     */
    private static final long serialVersionUID = -4901430917825641665L;
    /**
     * 唯一编号
     */
    private String intId;
    /**
     * 中文名称
     */
    private String zhName;
    /**
     * 百度经度
     */
    private double BaiduLongitude;
    /**
     * 百度纬度
     */
    private double BaiduLatitude;

    /**
     * 方位角
     */
    private double Dir;

    /**
     * 覆盖室内: 0 是室外小区1;是室内小区
     */
    private Integer IndoorSupport;

    /**
     * 网络制式
     */
    private String NETechnology;

    /**
     * 网元粒度
     */
    private String NeType;
}
