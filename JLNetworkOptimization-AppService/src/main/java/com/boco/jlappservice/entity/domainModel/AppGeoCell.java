package com.boco.jlappservice.entity.domainModel;

import lombok.Data;

/**
 * title：AppGeoCell
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 20:34
 */
@Data
public class AppGeoCell {

    private String Id;

    private int ColorId;

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

    private String Work_frqband;
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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getWork_frqband() {
        return Work_frqband;
    }

    public void setWork_frqband(String work_frqband) {
        Work_frqband = work_frqband;
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

    public int getColorId() {
        return ColorId;
    }

    public void setColorId(int colorId) {
        ColorId = colorId;
    }
}