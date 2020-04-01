package com.boco.jlappservice.entity.domainModel;

import com.boco.jlappservice.enums.NEGranularity;
import com.boco.jlappservice.enums.NETechnology;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：Cell
 * description:小区对象
 *
 * @author yumengjie
 * @date 2020/3/7 16:42
 */
@Data
public class Cell {
    @ApiModelProperty(value = "唯一编号")
    private String Id;
    @ApiModelProperty(value = "中文名称")
    private String Name;
    @ApiModelProperty(value = "GSM小区用LAC+CI确定. GSM：LAC; TD：LAC; LTE：TAC")
    private Integer LAC;
    @ApiModelProperty(value = "CI")
    private Integer CI;
    @ApiModelProperty(value = "CGI")
    private String CGI;
    @ApiModelProperty(value = "经度")
    private double Longitude;
    @ApiModelProperty(value = "纬度")
    private double Latitude;
    @ApiModelProperty(value = "百度经度")
    private double BaiduLongitude;
    @ApiModelProperty(value = "百度纬度")
    private double BaiduLatitude;
    @ApiModelProperty(value = "方位角")
    private double Dir;
    @ApiModelProperty(value = "Work_frqband")
    private String Work_frqband;
    @ApiModelProperty(value = "覆盖室内: 0 是室外小区1;是室内小区")
    private Integer IndoorSupport;
    @ApiModelProperty(value = "网络制式")
    private NETechnology NETechnology;
    @ApiModelProperty(value = "网元粒度")
    private NEGranularity NeType;
    @ApiModelProperty(value = "mNETechnology")
    private String mNETechnology;
    @ApiModelProperty(value = "mNeType")
    private String mNeType;

    public String getmNETechnology() {
        if(this.mNETechnology == null){
            return this.mNETechnology;
        }
        return mNETechnology.trim();
    }

    public void setmNETechnology(String mNETechnology) {
        this.mNETechnology = mNETechnology;
    }

    public String getmNeType() {
        if(this.mNeType == null){
            return this.mNeType;
        }
        return mNeType.trim();
    }

    public void setmNeType(String mNeType) {
        this.mNeType = mNeType;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getLAC() {
        return LAC;
    }

    public void setLAC(Integer lAC) {
        LAC = lAC;
    }

    public Integer getCI() {
        return CI;
    }

    public void setCI(Integer cI) {
        CI = cI;
    }

    public String getCGI() {
        return CGI;
    }

    public void setCGI(String cGI) {
        CGI = cGI;
    }

    public String getWork_frqband() {
        return Work_frqband;
    }

    public void setWork_frqband(String work_frqband) {
        Work_frqband = work_frqband;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
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

    public NETechnology getNETechnology() {
        return NETechnology;
    }

    public void setNETechnology(NETechnology nETechnology) {
        NETechnology = nETechnology;
    }

    public NEGranularity getNeType() {
        return NeType;
    }

    public void setNeType(NEGranularity neType) {
        NeType = neType;
    }

    public Cell(String id, String name, Integer lAC, Integer cI, String cGI,
                double longitude, double latitude, double baiduLongitude,
                double baiduLatitude, String work_frqband,double dir, Integer indoorSupport,
                NETechnology nETechnology, NEGranularity neType) {
        super();
        Id = id;
        Name = name;
        LAC = lAC;
        CI = cI;
        CGI = cGI;
        Longitude = longitude;
        Latitude = latitude;
        BaiduLongitude = baiduLongitude;
        BaiduLatitude = baiduLatitude;
        Work_frqband=work_frqband;
        Dir = dir;
        IndoorSupport = indoorSupport;
        NETechnology = nETechnology;
        NeType = neType;
    }

    public Cell(String id, String name, Integer cI, double baiduLongitude,
                double baiduLatitude, String work_frqband, NETechnology nETechnology,
                NEGranularity neType) {
        super();
        Id = id;
        Name = name;
        CI = cI;
        BaiduLongitude = baiduLongitude;
        BaiduLatitude = baiduLatitude;
        Work_frqband=work_frqband;
        NETechnology = nETechnology;
        NeType = neType;
    }

    public Cell() {
        super();
    }
}