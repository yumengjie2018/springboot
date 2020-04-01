package com.boco.jlappservice.entity.domainModel;

import com.boco.jlappservice.enums.NEGranularity;
import com.boco.jlappservice.enums.NETechnology;
import lombok.Data;

import java.util.ArrayList;

/**
 * title：GeoCell
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 16:58
 */
@Data
public class GeoCell extends Cell{

    public GeoCell(String id, String name, Integer lAC, Integer cI, String cGI,
                   double longitude, double latitude, double baiduLongitude,
                   double baiduLatitude, String work_frqband, double dir, Integer indoorSupport,
                   com.boco.jlappservice.enums.NETechnology nETechnology,
                   NEGranularity neType, Integer sysType, Integer uarfcn,
                   Integer cellParameterId, Integer earfcn, Integer pCI, Integer pN,
                   Integer sId, Integer nId, long regionID) {
        super(id, name, lAC, cI, cGI, longitude, latitude, baiduLongitude,
                baiduLatitude, work_frqband,dir, indoorSupport, nETechnology, neType);
        SysType = sysType;
        //Work_frqband=work_frqband;
        Uarfcn = uarfcn;
        CellParameterId = cellParameterId;
        Earfcn = earfcn;
        PCI = pCI;
        PN = pN;
        SId = sId;
        NId = nId;
        this.regionID = regionID;
    }

    public GeoCell(String id, String name, Integer cI, double baiduLongitude,
                   double baiduLatitude,String work_frqband,
                   NETechnology nETechnology,
                   NEGranularity neType) {
        super(id, name, cI, baiduLongitude,baiduLatitude, work_frqband, nETechnology, neType);
    }

    public GeoCell(String id, String name, Integer lAC, Integer cI, String cGI,
                   double longitude, double latitude, double baiduLongitude,
                   double baiduLatitude, String work_frqband,double dir, Integer indoorSupport,
                   NETechnology nETechnology,
                   NEGranularity neType) {
        super(id, name, lAC, cI, cGI, longitude, latitude, baiduLongitude,
                baiduLatitude,work_frqband, dir, indoorSupport, nETechnology, neType);
    }

    public GeoCell() {
        super();
    }

    /**
     *
     */
    private static final long serialVersionUID = -6514338473993615213L;
    private Integer SysType;// 1 :900小区 2:1800小区 4:900/1800小区
    // 移动2G小区起作用 1:1X小区 2:DO小区 4:1X/DO小区
    // 电信2/3G起作用 1:FDD 小区 2:TDD 小区
    // 电信4G起作用
    private Integer Uarfcn;// TDS频点+TDS扰码确定TDS小区
    private Integer CellParameterId;
    private Integer Earfcn;// LTE频点+LTE PCI确定LTE小区
    private Integer PCI;
    private Integer PN;// 电信2/3G小区用PN确定
    private Integer SId;
    private Integer NId;
    private long regionID;

    //制式频段 如：GSM900、1800；LTE的F、D频段
    private String band;


    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public Integer getSysType() {
        return SysType;
    }

    public void setSysType(Integer sysType) {
        SysType = sysType;
    }

    public Integer getUarfcn() {
        return Uarfcn;
    }

    public void setUarfcn(Integer uarfcn) {
        Uarfcn = uarfcn;
    }

    public Integer getCellParameterId() {
        return CellParameterId;
    }

    public void setCellParameterId(Integer cellParameterId) {
        CellParameterId = cellParameterId;
    }

    public Integer getEarfcn() {
        return Earfcn;
    }

    public void setEarfcn(Integer earfcn) {
        Earfcn = earfcn;
    }

    public Integer getPCI() {
        return PCI;
    }

    public void setPCI(Integer pCI) {
        PCI = pCI;
    }

    public Integer getPN() {
        return PN;
    }

    public void setPN(Integer pN) {
        PN = pN;
    }

    public Integer getSId() {
        return SId;
    }

    public void setSId(Integer sId) {
        SId = sId;
    }

    public Integer getNId() {
        return NId;
    }

    public void setNId(Integer nId) {
        NId = nId;
    }

    public static ArrayList<GeoCell> StringToList(String str) {
        String[] array = str.split(",");
        ArrayList<GeoCell> result = new ArrayList<GeoCell>();
        for (String geoCellStr : array) {
            GeoCell geoCell = new GeoCell();
            String[] geoCellArray = geoCellStr.split("\\|");

            geoCell.setId(geoCellArray[0]);
            geoCell.setName(geoCellArray[1]);
            geoCell.setBaiduLatitude(Double.parseDouble(geoCellArray[2]));
            geoCell.setBaiduLongitude(Double.parseDouble(geoCellArray[3]));
            geoCell.setCGI(geoCellArray[4]);
            geoCell.setDir(Double.parseDouble(geoCellArray[5]));
            geoCell.setLatitude(Double.parseDouble(geoCellArray[6]));
            geoCell.setLongitude(Double.parseDouble(geoCellArray[7]));
            geoCell.setWork_frqband(geoCellArray[8]);
            geoCell.setNETechnology(NETechnology.valueOf(geoCellArray[9]));
            geoCell.setCI(Integer.parseInt(geoCellArray[10]));
            geoCell.setIndoorSupport(Integer.parseInt(geoCellArray[11]));
            geoCell.setLAC(Integer.parseInt(geoCellArray[12]));
            geoCell.setNeType(NEGranularity.valueOf(geoCellArray[13]));
            geoCell.setSysType(Integer.parseInt(geoCellArray[14]));
            result.add(geoCell);
        }
        return result;
    }

    /**
     * @return the regionID
     */
    public long getRegionID() {
        return regionID;
    }

    /**
     * @param regionID
     *            the regionID to set
     */
    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }
}