package com.boco.jlappservice.utility;

import com.boco.jlappservice.entity.domainModel.*;
import com.boco.jlappservice.enums.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * title：AnalysisParameterUtil
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 16:40
 */

public class AnalysisParameterUtil {
    /**
     * 小区分析公参列表,增加百度转换偏移经纬度
     *
     * @param result
     * @return
     */
    public ArrayList<CellParameter> setBaiduGeoCell(
            ArrayList<CellParameter> result) {
        GeoCell geoCell = new GeoCell();
        for (CellParameter cellParameter : result) {
            if (cellParameter.getEnName().trim().equals("longitude")) {
                double value = Double.parseDouble(cellParameter.getKPIValue());
                geoCell.setLongitude(value);
            }
            if (cellParameter.getEnName().trim().equals("latitude")) {
                double value = Double.parseDouble(cellParameter.getKPIValue());
                geoCell.setLatitude(value);
            }
        }
        BaiduOffsetUtil util = new BaiduOffsetUtil();
        geoCell = util.SetBaiduOffsetByLonLat(geoCell);

        CellParameter longitudePara = new CellParameter();
        CellParameter latitudePara = new CellParameter();

        longitudePara.setEnName("BaiDuLongitude");
        longitudePara.setKPIValue(Double.toString(geoCell.getBaiduLongitude()));
        latitudePara.setEnName("BaiDuLatitude");
        latitudePara.setKPIValue(Double.toString(geoCell.getBaiduLatitude()));

        result.add(longitudePara);
        result.add(latitudePara);
        return result;
    }

    /**
     * @param listRnopMnoParameter
     * @param cellParaStr
     * @return
     */
    public ArrayList<CellPara> setCellParaList(
            ArrayList<RnopMnoParameter> listRnopMnoParameter, String cellParaStr) {
        ArrayList<CellPara> result;
        result = new ArrayList<CellPara>();
        for (int i = 0; i <= listRnopMnoParameter.size() - 1; i++) {
            for (int j = 0; j <= cellParaStr.split(",").length - 1; j++) {
                String parameter = cellParaStr.split(",")[j];
                String fieldName=listRnopMnoParameter.get(i).getFiledName();
                if(listRnopMnoParameter.get(i).getFieldIsSql()==1){
                    Integer leg=listRnopMnoParameter.get(i).getFiledName()
                            .split(" ").length;
                    fieldName=listRnopMnoParameter.get(i).getFiledName()
                            .split(" ")[leg-1];
                }
                if (fieldName.equalsIgnoreCase(parameter.split("=")[0].trim())) {
                    CellPara cellPara = new CellPara();
                    cellPara.setZhName(listRnopMnoParameter.get(i).getZhName());
                    cellPara.setEnName(parameter.split("=")[0]);
                    if (parameter.split("=").length == 2)
                        cellPara.setKPIValue(parameter.split("=")[1]);
                    cellPara.setIsRelatedOtherKPI(listRnopMnoParameter.get(i)
                            .getIsRelatedOtherKPI());
                    cellPara.setRelatedNeType(listRnopMnoParameter.get(i)
                            .getNeGranularity());
                    cellPara.setId(listRnopMnoParameter.get(i).getId());
                    result.add(cellPara);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @param scanStartTime
     * @param listRnopMnoParameter
     * @param cellPerformanceStr
     * @return
     */
    public ArrayList<CellPerformance> setCellPerformanceList(
            String scanStartTime,
            ArrayList<RnopMnoParameter> listRnopMnoParameter,
            String cellPerformanceStr) {
        ArrayList<CellPerformance> result;
        result = new ArrayList<CellPerformance>();
        for (int i = 0; i <= listRnopMnoParameter.size() - 1; i++) {
            for (int j = 0; j <= cellPerformanceStr.split(",").length - 1; j++) {
                String performance = cellPerformanceStr.split(",")[j];

                if (listRnopMnoParameter.get(i).getFiledName().trim()
                        .equalsIgnoreCase(performance.split("=")[0].trim())) {

                    CellPerformance cellPerformance = new CellPerformance();
                    cellPerformance.setScanStartTime(VeDate
                            .strToDate(scanStartTime));
                    cellPerformance.setId(listRnopMnoParameter.get(i).getId());
                    cellPerformance.setZhName(listRnopMnoParameter.get(i)
                            .getZhName());
                    cellPerformance.setEnName(performance.split("=")[0]);
                    if (performance.split("=").length == 2)
                        cellPerformance.setPerformanceValue(performance
                                .split("=")[1]);

                    result.add(cellPerformance);
                    break;
                }
            }
        }
        return result;
    }

    public HashMap<String, String> GetScanStartEndTimeBySumLevel(
            SumLevel sumLevel, String scanStartTime) {
        String tempTime = scanStartTime;
        String scanEndTime = "";
        HashMap<String, String> map = new HashMap<String, String>();
        if (SumLevel.Hour.equals(sumLevel)) {
            scanStartTime = VeDate.getPreTime(scanStartTime, (-24 * 60) + "");
            scanEndTime = tempTime;
        } else if (SumLevel.Day.equals(sumLevel)) {
            scanStartTime = VeDate.getPreTime(scanStartTime, (-14 * 60 * 24)
                    + "");
            scanStartTime = scanStartTime.split(" ")[0];
            scanEndTime = tempTime;
        } else if (SumLevel.Week.equals(sumLevel)) {
            scanStartTime = VeDate.getPreTime(scanStartTime,
                    (-7 * 60 * 24 * 26) + "");
            scanStartTime = scanStartTime.split(" ")[0];
            scanEndTime = tempTime;
        } else if (SumLevel.Month.equals(sumLevel)) {
            scanStartTime = VeDate.getPreTime(scanStartTime,
                    (-31 * 60 * 24 * 12) + "");
            scanStartTime = scanStartTime.split(" ")[0];
            scanEndTime = tempTime;
        }
        map.put("scanStartTime", scanStartTime);
        map.put("scanEndTime", scanEndTime);
        return map;
    }

    /**
     * @param listRnopMnoParameter
     * @param cellParameterStr
     * @return
     */
    public ArrayList<CellParameter> setCellParameterList(
            ArrayList<RnopMnoParameter> listRnopMnoParameter,
            String cellParameterStr) {
        ArrayList<CellParameter> result = new ArrayList<CellParameter>();
        for (int i = 0; i <= listRnopMnoParameter.size() - 1; i++) {
            for (int j = 0; j <= cellParameterStr.split(",").length - 1; j++) {
                String parameter = cellParameterStr.split(",")[j];
                String fieldName=listRnopMnoParameter.get(i).getFiledName();
                if(listRnopMnoParameter.get(i).getFieldIsSql()==1){
                    Integer leg=listRnopMnoParameter.get(i).getFiledName()
                            .split(" ").length;
                    fieldName=listRnopMnoParameter.get(i).getFiledName()
                            .split(" ")[leg-1];
                }
                if (fieldName.equalsIgnoreCase(parameter.split("=")[0].trim())) {
                    CellParameter cellParameter = new CellParameter();
                    cellParameter.setZhName(listRnopMnoParameter.get(i)
                            .getZhName().trim());
                    cellParameter.setEnName(parameter.split("=")[0]);
                    if (parameter.split("=").length == 2)
                        cellParameter.setKPIValue(parameter.split("=")[1]);
                    cellParameter.setIsRelatedOtherKPI(listRnopMnoParameter
                            .get(i).getIsRelatedOtherKPI());
                    cellParameter.setRelatedNeType(listRnopMnoParameter.get(i)
                            .getNeGranularity());
                    result.add(cellParameter);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @param listRnopMnoStructureIndex
     * @param cellStructureIndexStr
     * @return
     */
    public ArrayList<StructureIndex> setStructureIndexList(
            ArrayList<RnopMnoParameter> listRnopMnoStructureIndex,
            String cellStructureIndexStr) {
        ArrayList<StructureIndex> result;
        result = new ArrayList<StructureIndex>();
        for (int i = 0; i <= listRnopMnoStructureIndex.size() - 1; i++) {
            for (int j = 0; j <= cellStructureIndexStr.split(",").length - 1; j++) {
                String structureindex = cellStructureIndexStr.split(",")[j];
                String fieldName=listRnopMnoStructureIndex.get(i).getFiledName();
                if(listRnopMnoStructureIndex.get(i).getFieldIsSql()==1){
                    Integer leg=listRnopMnoStructureIndex.get(i).getFiledName()
                            .split(" ").length;
                    fieldName=listRnopMnoStructureIndex.get(i).getFiledName()
                            .split(" ")[leg-1];
                }
                if (fieldName.equalsIgnoreCase(structureindex.split("=")[0].trim())) {
                    StructureIndex StructureIndex = new StructureIndex();
                    StructureIndex.setZhName(listRnopMnoStructureIndex.get(i)
                            .getZhName().trim());
                    StructureIndex.setEnName(structureindex.split("=")[0]);
                    if (structureindex.split("=").length == 2)
                        StructureIndex.setValue(structureindex.split("=")[1]);
                    result.add(StructureIndex);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @param listRnopMnoLTEParameterQuery
     * @param cellLTEParameterQueryStr
     * @return
     */
    public ArrayList<LTEParameterQuery> setLTEParameterQueryList(
            ArrayList<RnopMnoParameterQuery> listRnopMnoLTEParameterQuery,
            String cellLTEParameterQueryStr) {
        ArrayList<LTEParameterQuery> result;
        result = new ArrayList<LTEParameterQuery>();
        for (int i = 0; i <= listRnopMnoLTEParameterQuery.size() - 1; i++) {
            for (int j = 0; j <= cellLTEParameterQueryStr.split(",").length - 1; j++) {
                String lteparameterquery = cellLTEParameterQueryStr.split(",")[j];
                String fieldName=listRnopMnoLTEParameterQuery.get(i).getFiledName();
                if(listRnopMnoLTEParameterQuery.get(i).getFieldIsSql()==1){
                    Integer leg=listRnopMnoLTEParameterQuery.get(i).getFiledName()
                            .split(" ").length;
                    fieldName=listRnopMnoLTEParameterQuery.get(i).getFiledName()
                            .split(" ")[leg-1];
                }
                if (fieldName.equalsIgnoreCase(lteparameterquery.split("=")[0].trim())) {
                    LTEParameterQuery LTEParameterQuery = new LTEParameterQuery();
                    LTEParameterQuery.setZhName(listRnopMnoLTEParameterQuery.get(i)
                            .getZhName().trim());
                    LTEParameterQuery.setEnName(lteparameterquery.split("=")[0]);
                    if (lteparameterquery.split("=").length == 2)
                        LTEParameterQuery.setValue(lteparameterquery.split("=")[1]);
                    result.add(LTEParameterQuery);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @param listRnopMnoLTEParameterValue
     * @param cellLTEParameterValueStr
     * @return
     */
    public ArrayList<LTEParameterValue> setLTEParameterValueList(
            ArrayList<RnopMnoParameterQuery> listRnopMnoLTEParameterValue,
            String cellLTEParameterValueStr) {
        ArrayList<LTEParameterValue> result;
        result = new ArrayList<LTEParameterValue>();
        for (int i = 0; i <= listRnopMnoLTEParameterValue.size() - 1; i++) {
            for (int j = 0; j <= cellLTEParameterValueStr.split(",").length - 1; j++) {
                String lteparametervalue = cellLTEParameterValueStr.split(",")[j];
                String fieldName=listRnopMnoLTEParameterValue.get(i).getFiledName();
                if(listRnopMnoLTEParameterValue.get(i).getFieldIsSql()==1){
                    Integer leg=listRnopMnoLTEParameterValue.get(i).getFiledName()
                            .split(" ").length;
                    fieldName=listRnopMnoLTEParameterValue.get(i).getFiledName()
                            .split(" ")[leg-1];
                }
                if (fieldName.equalsIgnoreCase(lteparametervalue.split("=")[0].trim())) {
                    LTEParameterValue LTEParameterValue = new LTEParameterValue();
                    LTEParameterValue.setZhName(listRnopMnoLTEParameterValue.get(i)
                            .getZhName().trim());
                    //LTEParameterValue.setEnName(lteparametervalue.split("=")[0]);
                    if (lteparametervalue.split("=").length == 2)
                        LTEParameterValue.setValue(lteparametervalue.split("=")[1]);
                    result.add(LTEParameterValue);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 返回小区分析中(工参\性能\告警\参数)动态查询sql
     *
     * @param ne
     *            网络制式
     * @param netype
     *            网元粒度
     * @param parameterType
     *            参数类型(工参\性能\告警\参数)
     * @param scanStartTime
     *            查询起始时间
     * @param sum_level
     *            时间粒度
     * @param id
     *            小区编号
     * @param listRnopMnoParameter
     *            数据库存储的可配置参数列表
     * @return HashMap中 key-value：fieldName 查询字段;tableName 查询表及条件
     */
    public HashMap<String, Object> GetTableFieldString(NETechnology ne,
                                                       NEGranularity netype, ParameterType parameterType,
                                                       String scanStartTime, SumLevel sum_level, String id,
                                                       ArrayList<RnopMnoParameter> listRnopMnoParameter) {

        String fieldName = "", tableName = "";
        ArrayList<String> distinctTableName = new ArrayList<String>();
        int i = 0;
        for (RnopMnoParameter rnopMnoParameter : listRnopMnoParameter) {
            if (!distinctTableName.contains(rnopMnoParameter.getTableName().toLowerCase())) {
                distinctTableName.add(rnopMnoParameter.getTableName().toLowerCase());
            }
            if ((ne == NETechnology.GSM || ne == NETechnology.TD || ne == NETechnology.LTE)
                    // && (netype == NEGranularity.Cell
                    // || netype == NEGranularity.UtranCell || netype ==
                    // NEGranularity.Eutrancell)
                    && parameterType == ParameterType.performance) {
                fieldName = this.GetPerformanceCMCCFieldStr(fieldName,
                        rnopMnoParameter.getTableName(), rnopMnoParameter);

                // 增加一个别名,函数名太长
                i++;
                String typeAlias = "  Performance" + i;
                rnopMnoParameter.setFiledName(typeAlias);
                fieldName += typeAlias + ",";
            } else {
                fieldName = this.getFiledName(fieldName, rnopMnoParameter);
            }
        }

        return FormatTableFieldName(fieldName, tableName, distinctTableName,
                id, scanStartTime, sum_level,netype);

    }

    public HashMap<String, Object> GetTableFieldString5(NETechnology ne,
                                                        NEGranularity netype, ParameterType parameterType,
                                                        String scanStartTime, SumLevel sum_level, String id,
                                                        ArrayList<RnopMnoParameter> listRnopMnoParameter) {

        String fieldName = "", tableName = "";
        ArrayList<String> distinctTableName = new ArrayList<String>();
        int i = 0;
        for (RnopMnoParameter rnopMnoParameter : listRnopMnoParameter) {
            if (!distinctTableName.contains(rnopMnoParameter.getTableName().toLowerCase())) {
                distinctTableName.add(rnopMnoParameter.getTableName().toLowerCase());
            }
            if ((ne == NETechnology.GSM || ne == NETechnology.TD || ne == NETechnology.LTE)
                    // && (netype == NEGranularity.Cell
                    // || netype == NEGranularity.UtranCell || netype ==
                    // NEGranularity.Eutrancell)
                    && parameterType == ParameterType.performance) {
                fieldName = this.GetPerformanceCMCCFieldStr(fieldName,
                        rnopMnoParameter.getTableName(), rnopMnoParameter);

                // 增加一个别名,函数名太长
                i++;
                String typeAlias = "  Performance" + i;
                rnopMnoParameter.setFiledName(typeAlias);
                fieldName += typeAlias + ",";
            } else {
                fieldName = this.getFiledName(fieldName, rnopMnoParameter);
            }
        }

        return FormatTableFieldName5(ne,fieldName, tableName, distinctTableName,
                id, scanStartTime, sum_level,netype);

    }

    public HashMap<String, String> GetTableFieldKpiString(
            String scanStartTime, String id,
            ArrayList<RnopMnoKpi> listRnopMnoKpi) {

        String fieldName = "", tableName = "";
        ArrayList<String> distinctTableName = new ArrayList<String>();
        int i = 0;
        for (RnopMnoKpi rnopMnoKpi : listRnopMnoKpi) {
            if (!distinctTableName.contains(rnopMnoKpi.getTableName().toLowerCase())) {
                distinctTableName.add(rnopMnoKpi.getTableName().toLowerCase());
            }
            fieldName = this.getFiledKpiName(fieldName, rnopMnoKpi);
        }

        return FormatTableFieldKpiName(fieldName, tableName, distinctTableName,
                id, scanStartTime);

    }

    public HashMap<String, Object> GetTableFieldString2(NETechnology ne,
                                                        NEGranularity netype, ReportFormType reportformType,
                                                        String scanstarttime, Long regionId,Long vendorId,
                                                        ArrayList<RnopMnoParameterQuery> listRnopMnoParameter) {

        String fieldName = "", tableName = "";
        ArrayList<String> distinctTableName = new ArrayList<String>();
        int i = 0;
        for (RnopMnoParameterQuery rnopMnoParameter : listRnopMnoParameter) {
            if (!distinctTableName.contains(rnopMnoParameter.getTableName().toLowerCase())) {
                distinctTableName.add(rnopMnoParameter.getTableName().toLowerCase());
            }
            if ((ne == NETechnology.LTE) && reportformType == ReportFormType.lteparameterquery) {
                fieldName = this.GetPerformanceCMCCFieldStr2(fieldName,
                        rnopMnoParameter.getTableName(), rnopMnoParameter);

                // 增加一个别名,函数名太长
                i++;
                String typeAlias = "  Performance" + i;
                rnopMnoParameter.setFiledName(typeAlias);
                fieldName += typeAlias + ",";
            } else {
                fieldName = this.getFiledName2(fieldName, rnopMnoParameter);
            }
        }

        return FormatTableFieldName2(fieldName, tableName, distinctTableName,
                regionId, scanstarttime, vendorId,netype);

    }

    public HashMap<String, Object> GetTableFieldString3(NETechnology ne,
                                                        NEGranularity netype, ReportFormType reportformType,
                                                        String scanstarttime, Long Id,
                                                        ArrayList<RnopMnoParameterQuery> listRnopMnoParameter) {

        String fieldName = "", tableName = "";
        ArrayList<String> distinctTableName = new ArrayList<String>();
        int i = 0;
        for (RnopMnoParameterQuery rnopMnoParameter : listRnopMnoParameter) {
            if (!distinctTableName.contains(rnopMnoParameter.getTableName().toLowerCase())) {
                distinctTableName.add(rnopMnoParameter.getTableName().toLowerCase());
            }
            if ((ne == NETechnology.LTE) && reportformType == ReportFormType.lteparameterquery) {
                fieldName = this.GetPerformanceCMCCFieldStr2(fieldName,
                        rnopMnoParameter.getTableName(), rnopMnoParameter);

                // 增加一个别名,函数名太长
                i++;
                String typeAlias = "  Performance" + i;
                rnopMnoParameter.setFiledName(typeAlias);
                fieldName += typeAlias + ",";
            } else {
                fieldName = this.getFiledName2(fieldName, rnopMnoParameter);
            }
        }

        return FormatTableFieldName3(fieldName, tableName, distinctTableName,
                Id, scanstarttime,netype);

    }

    public HashMap<String, Object> GetTableFieldString4(NETechnology ne,
                                                        NEGranularity netype, ReportFormType reportformType,
                                                        String scanstarttime, Long Id,
                                                        ArrayList<RnopMnoParameterQuery> listRnopMnoParameter) {

        String fieldName = "", tableName = "";
        ArrayList<String> distinctTableName = new ArrayList<String>();
        int i = 0;
        for (RnopMnoParameterQuery rnopMnoParameter : listRnopMnoParameter) {
            if (!distinctTableName.contains(rnopMnoParameter.getTableName().toLowerCase())) {
                distinctTableName.add(rnopMnoParameter.getTableName().toLowerCase());
            }
            if ((ne == NETechnology.LTE) && reportformType == ReportFormType.lteparameterquery) {
                fieldName = this.GetPerformanceCMCCFieldStr2(fieldName,
                        rnopMnoParameter.getTableName(), rnopMnoParameter);

                // 增加一个别名,函数名太长
                i++;
                String typeAlias = "  Performance" + i;
                rnopMnoParameter.setFiledName(typeAlias);
                fieldName += typeAlias + ",";
            } else {
                fieldName = this.getFiledName2(fieldName, rnopMnoParameter);
            }
        }

        return FormatTableFieldName4(fieldName, tableName, distinctTableName,
                Id, scanstarttime,netype);

    }

    /**
     * 格式化查询字段，如表名前缀、中文格式转换、浮点型四舍五入
     *
     * @param fieldName
     *            查询字段
     * @param rnopMnoParameter
     *            查询参数
     * @return 格式化后的查询字段
     */
    public String getFiledName(String fieldName,
                               RnopMnoParameter rnopMnoParameter) {
        if (rnopMnoParameter.getFieldIsSql() != 1) {
            fieldName += rnopMnoParameter.getTableName() + "."
                    + rnopMnoParameter.getFiledName() + ",";
        } else {
            fieldName += rnopMnoParameter.getFiledName() + ",";
        }

        return fieldName;
        // if ("longitude".equals(rnopMnoParameter.getFiledName())
        // || "latitude".equals(rnopMnoParameter.getFiledName())) {
        // fieldName += "ROUND(" + rnopMnoParameter.getTableName() + "."
        // + rnopMnoParameter.getFiledName() + ",6) "
        // + rnopMnoParameter.getFiledName() + ",";
        // } else if ("do_cell".equals(rnopMnoParameter.getFiledName())) {
        // String do_cell = rnopMnoParameter.getTableName() + "."
        // + rnopMnoParameter.getFiledName();
        // fieldName += "(case  when " + do_cell + "=0 then '纯1X小区' "
        // + " when " + do_cell + " =1  then '纯DO小区' " + " when  "
        // + do_cell + " =2  then '混合小区' " + " else '混合小区' end)  "
        // + rnopMnoParameter.getFiledName() + ",";
        // } else if ("SYS_TYPE".equals(rnopMnoParameter.getFiledName())) {
        // String SYS_TYPE = rnopMnoParameter.getTableName() + "."
        // + rnopMnoParameter.getFiledName();
        // fieldName += "(case  when " + SYS_TYPE + "=0 then '800M' "
        // + " when " + SYS_TYPE + " =1  then '900M' " + " when  "
        // + SYS_TYPE + " =2  then '1800M' " + " when  " + SYS_TYPE
        // + " =3  then '1900M' " + " when  " + SYS_TYPE
        // + " =4  then '900/1800M' " + " else '900/1800M' end) "
        // + rnopMnoParameter.getFiledName() + ",";
        // } else {
        // fieldName += rnopMnoParameter.getTableName() + "."
        // + rnopMnoParameter.getFiledName() + ",";
        // }
        // return fieldName;
    }

    public String getFiledKpiName(String fieldName,
                                  RnopMnoKpi rnopMnoKpi) {
        if (rnopMnoKpi.getFieldIsSql() != 1) {
            fieldName += rnopMnoKpi.getTableName() + "."
                    + rnopMnoKpi.getFiledName() + ",";
        } else {
            fieldName += rnopMnoKpi.getFiledName() + ",";
        }

        return fieldName;
    }

    public String getFiledName2(String fieldName,
                                RnopMnoParameterQuery rnopMnoParameter) {
        if (rnopMnoParameter.getFieldIsSql() != 1) {
            fieldName += rnopMnoParameter.getTableName() + "."
                    + rnopMnoParameter.getFiledName() + ",";
        } else {
            fieldName += rnopMnoParameter.getFiledName() + ",";
        }

        return fieldName;
    }

    /**
     * 格式化查询字段和查询表以及查询条件
     *
     * @param fieldName
     *            查询字段
     * @param tableName
     *            查询表
     * @param distinctTableName
     *            去重后的唯一表名序列
     * @param id
     *            网元编号
     * @param scanStartTime
     *            查询起始时间
     * @param sumlevel
     *            时间粒度
     * @return HashMap中 key-value：fieldName 查询字段;tableName 查询表及条件
     */
    public HashMap<String, Object> FormatTableFieldName(String fieldName,
                                                        String tableName, ArrayList<String> distinctTableName, String id,
                                                        String scanStartTime, SumLevel sumlevel,NEGranularity netype) {
        String whereStr = ".int_id=" + id + " and ", sumLevelStr = "", scanStartTimeStr = "";
        if (sumlevel != null)
            sumLevelStr = ".sum_level=" + sumlevel.getValue() + " and ";
        if (scanStartTime != null && scanStartTime != "trunc(sysdate)"){
            scanStartTimeStr = ".scan_start_time=" + scanStartTime + " and ";
        }else {
            scanStartTimeStr = ".scan_start_time=trunc(sysdate) and ";
        }
        // 去除最后一个,
        fieldName = fieldName.substring(0, fieldName.length() - 1);
        for (String string : distinctTableName) {
            tableName += string + ",";
        }

        // 去除最后一个,
        tableName = tableName.substring(0, tableName.length() - 1);
        tableName += " where ";
        distinctTableName.remove("region_city");

        // tableName += " where rownum<=1 and ";
        for (String string : distinctTableName) {
            tableName += string + whereStr;
            if (sumlevel != null)
                tableName += string + sumLevelStr;
            if (scanStartTime != null ){
                if(string.indexOf("tco_pro") == -1){
                    tableName += string + scanStartTimeStr;
                }
            }
        }
        // 去除最后一个and
        tableName = tableName.substring(0, tableName.length() - 4);

        //增加地市区县字段
		/*if(tableName.toLowerCase().indexOf("region_city")>-1){
			tableName +=" and region_city.city_id="+netype+".CITY_ID";
		}*/


        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("tableName", tableName);
        result.put("fieldName", fieldName);
        return result;
    }

    public HashMap<String, String> FormatTableFieldKpiName(String fieldName,
                                                           String tableName, ArrayList<String> distinctTableName, String id,
                                                           String scanStartTime) {
        String whereStr = ".int_id in(" + id + ") and ", sumLevelStr = "", scanStartTimeStr = "";
        sumLevelStr = ".sum_level=1 and ";
        if (scanStartTime != null && scanStartTime != "trunc(sysdate)"){
            scanStartTimeStr = ".scan_start_time=" + scanStartTime + " and ";
        }else {
            scanStartTimeStr = ".scan_start_time=trunc(sysdate) and ";
        }
        // 去除最后一个,
        fieldName = fieldName.substring(0, fieldName.length() - 1);
        for (String string : distinctTableName) {
            tableName += string + ",";
        }

        // 去除最后一个,
        tableName = tableName.substring(0, tableName.length() - 1);
        distinctTableName.remove("region_city");
        distinctTableName.remove("eutrancell");

        tableName += " where ";
        //tableName += " where rownum=1 and ";
        for (String string : distinctTableName) {
            tableName += string + whereStr;
            tableName += string + sumLevelStr;
            if (scanStartTime != null ){
                if(string.indexOf("tco_pro") == -1){
                    tableName += string + scanStartTimeStr;
                }
            }
        }
        // 去除最后一个and
        tableName = tableName.substring(0, tableName.length() - 4);

        //增加地市区县字段
        if(tableName.toLowerCase().indexOf("eutrancell")>-1){
            tableName +=" and v_tpa_eutrancell_oth_ne.int_id=eutrancell.int_id ";
        }

        HashMap<String, String> result = new HashMap<String, String>();
        result.put("tableName", tableName);
        result.put("fieldName", fieldName);
        return result;
    }

    public HashMap<String, Object> FormatTableFieldName2(String fieldName,
                                                         String tableName, ArrayList<String> distinctTableName, Long regionId,String scanstarttime,
                                                         Long vendorId, NEGranularity netype) {
        String whereStr = ".region_id=" + regionId + " and " ,
                //+ ".vendor_id=" + vendorId + " and " + ".scan_start_time=" + scanstarttime + " and ",
                vendorIdStr= "",scanStartTimeStr = "";
        if (vendorId != null)
            vendorIdStr = ".vendor_id=" + vendorId + " and ";
        if (scanstarttime != null && scanstarttime != "trunc(sysdate)"){
            scanStartTimeStr = ".scan_start_time=" + "to_date('" +scanstarttime +"','yyyy-mm-dd')"+ " and ";
        }else {
            scanStartTimeStr = ".scan_start_time=trunc(sysdate-1) and ";
        }
        // 去除最后一个,
        fieldName = fieldName.substring(0, fieldName.length() - 1);
        for (String string : distinctTableName) {
            tableName += string + ",";
        }

        // 去除最后一个,
        tableName = tableName.substring(0, tableName.length() - 1);
        tableName += " where ";
        distinctTableName.remove("region_city");
        for (String string : distinctTableName) {
            tableName += string + whereStr;
            if (vendorId != null)
                tableName += string + vendorIdStr;
            if (scanstarttime != null ){
                if(string.indexOf("tco_pro") == -1){
                    tableName += string + scanStartTimeStr;
                }
            }
        }
        // 去除最后一个and
        tableName = tableName.substring(0, tableName.length() - 4);

        //增加地市区县字段
		/*if(tableName.toLowerCase().indexOf("region_city")>-1){
			tableName +=" and region_city.city_id="+netype+".CITY_ID";
		}*/


        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("tableName", tableName);
        result.put("fieldName", fieldName);
        return result;
    }

    public HashMap<String, Object> FormatTableFieldName3(String fieldName,
                                                         String tableName, ArrayList<String> distinctTableName, Long Id,String scanstarttime,
                                                         NEGranularity netype) {
        String whereStr = ".int_id=" + Id + " and " ,
                scanStartTimeStr = "";
        if (scanstarttime != null && scanstarttime != "trunc(sysdate)"){
            scanStartTimeStr = ".scan_start_time=" + "to_date('" +scanstarttime +"','yyyy-mm-dd')"+ " and ";
        }else {
            scanStartTimeStr = ".scan_start_time=trunc(sysdate-1) and ";
        }
        // 去除最后一个,
        fieldName = fieldName.substring(0, fieldName.length() - 1);
        for (String string : distinctTableName) {
            tableName += string + ",";
        }

        // 去除最后一个,
        tableName = tableName.substring(0, tableName.length() - 1);
        tableName += " where ";
        distinctTableName.remove("region_city");
        for (String string : distinctTableName) {
            tableName += string + whereStr;
            if (scanstarttime != null ){
                if(string.indexOf("tco_pro") == -1){
                    tableName += string + scanStartTimeStr;
                }
            }
        }
        // 去除最后一个and
        tableName = tableName.substring(0, tableName.length() - 4);

        //增加地市区县字段
        if(tableName.toLowerCase().indexOf("region_city")>-1){
            tableName +=" and region_city.city_id=tcc_eutrancell.int_id " +
                    "and tcc_eutrancell.int_id = tcc_tco_pro_eutrancell.int_id";
        }

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("tableName", tableName);
        result.put("fieldName", fieldName);
        return result;
    }

    public HashMap<String, Object> FormatTableFieldName4(String fieldName,
                                                         String tableName, ArrayList<String> distinctTableName, Long Id,String scanstarttime,
                                                         NEGranularity netype) {
        String whereStr = ".int_id=" + Id + " and " ,
                scanStartTimeStr = "";
        if (scanstarttime != null && scanstarttime != "trunc(sysdate)"){
            scanStartTimeStr = ".scan_start_time=" + "to_date('" +scanstarttime +"','yyyy-mm-dd')"+ " and ";
        }else {
            scanStartTimeStr = ".scan_start_time=trunc(sysdate-1) and ";
        }
        // 去除最后一个,
        fieldName = fieldName.substring(0, fieldName.length() - 1);
        for (String string : distinctTableName) {
            tableName += string + ",";
        }

        // 去除最后一个,
        tableName = tableName.substring(0, tableName.length() - 1);
        tableName += " where ";
        distinctTableName.remove("region_city");
        for (String string : distinctTableName) {
            tableName += string + whereStr;
            if (scanstarttime != null ){
                if(string.indexOf("tco_pro") == -1){
                    tableName += string + scanStartTimeStr;
                }
            }
        }
        // 去除最后一个and
        tableName = tableName.substring(0, tableName.length() - 4);

        //增加地市区县字段
        if(tableName.toLowerCase().indexOf("region_city")>-1){
            tableName +=" and region_city.city_id=tcc_eutrancell.int_id " +
                    "and tcc_eutrancell.int_id = tcc_tco_pro_eutrancell.int_id";
        }

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("tableName", tableName);
        result.put("fieldName", fieldName);
        return result;
    }

    public HashMap<String, Object> FormatTableFieldName5(NETechnology ne,String fieldName,
                                                         String tableName, ArrayList<String> distinctTableName, String id,
                                                         String scanStartTime, SumLevel sumlevel,NEGranularity netype) {
        String whereStr = ".int_id=" + id + " and ", sumLevelStr = "", scanStartTimeStr = "";
        if (sumlevel != null)
            sumLevelStr = ".sum_level=" + sumlevel.getValue() + " and ";
        if (scanStartTime != null && scanStartTime != "trunc(sysdate)"){
            scanStartTimeStr = ".scan_start_time=" + scanStartTime + " and ";
        }else {
            scanStartTimeStr = ".scan_start_time=trunc(sysdate) and ";
        }
        // 去除最后一个,
        fieldName = fieldName.substring(0, fieldName.length() - 1);
        for (String string : distinctTableName) {
            tableName += string + ",";
        }

        // 去除最后一个,
        tableName = tableName.substring(0, tableName.length() - 1);
        tableName += " where ";
        distinctTableName.remove("region_city");
        if(ne == NETechnology.LTE){
            tableName += " region_city.city_id=eutrancell.city_id and ";
        }
        if(ne == NETechnology.GSM){
            tableName += " region_city.city_id=cell.city_id and ";
        }
        if(ne == NETechnology.TD){
            tableName += " region_city.city_id=utrancell.city_id and ";
        }
        System.out.print(ne);
        for (String string : distinctTableName) {
            tableName += string + whereStr;
            if (sumlevel != null)
                tableName += string + sumLevelStr;
            if (scanStartTime != null ){
                if(string.indexOf("tco_pro") == -1){
                    tableName += string + scanStartTimeStr;
                }
            }
        }
        // 去除最后一个and
        tableName = tableName.substring(0, tableName.length() - 4);

        //增加地市区县字段
		/*if(tableName.toLowerCase().indexOf("region_city")>-1){
			tableName +=" and region_city.city_id="+netype+".CITY_ID";
		}*/


        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("tableName", tableName);
        result.put("fieldName", fieldName);
        return result;
    }

    /**
     * 获取移动版网元性能查询的查询字段（因为移动版本在数据库中配置的性能字段需要进行运算后得出）
     *
     * @param fieldName
     *            查询字段
     * @param tableName
     *            查询表
     * @param rnopMnoParameter
     *            查询参数
     * @return 格式化后的查询字段
     */
    public String GetPerformanceCMCCFieldStr(String fieldName,
                                             String tableName, RnopMnoParameter rnopMnoParameter) {
        String[] replaceSymbol = new String[] { "(", ",", "+", "-", "*" };
        String tempField = rnopMnoParameter.getFiledName();
        boolean simpleFiled = true;
        for (String string : replaceSymbol) {
            // 主要是判断运算符后面的参数是否为字段名,还得去除前面的空格,如果是数字,则不用添加表名
            if (tempField.contains(string)) {
                String[] tempFiledSplitBySymbol = tempField
                        .split("//" + string);
                tempField = tempFiledSplitBySymbol[0] + string;
                for (int i = 1; i < tempFiledSplitBySymbol.length; i++) {
                    if (firstIsLetter(tempFiledSplitBySymbol[i].trim())) {
                        if (!tempFiledSplitBySymbol[i].trim().startsWith(
                                "sfb_divfloat_1")
                                && !tempFiledSplitBySymbol[i].trim()
                                .startsWith("round"))
                            tempField += tableName + "."
                                    + tempFiledSplitBySymbol[i].trim() + string;
                        else
                            tempField += tempFiledSplitBySymbol[i].trim()
                                    + string;
                    } else
                        tempField += tempFiledSplitBySymbol[i].trim() + string;
                }
                tempField = tempField.substring(0, tempField.length() - 1);
            }
            simpleFiled = false;
        }
        if (simpleFiled)
            tempField = rnopMnoParameter.getTableName() + "."
                    + rnopMnoParameter.getFiledName();
        if (rnopMnoParameter.getIsPercent() == 1) { // 增加截取精度两位小数,如果指标为百分比,则乘以100
            if(tempField.equals("PdcchCceUtil/PdcchCceAvail")){
                tempField="decode(PdcchCceAvail,0,0,null,0,round("+tempField+" * 100,2))";
            }else {
                tempField = "round(" + tempField + " * 100,2) ";
            }
        } else {
            tempField = "round(" + tempField + ",2) ";
        }
        return fieldName += tempField;
    }

    public String GetPerformanceCMCCFieldStr2(String fieldName,
                                              String tableName, RnopMnoParameterQuery rnopMnoParameter) {
        String[] replaceSymbol = new String[] { "(", ",", "+", "-", "*" };
        String tempField = rnopMnoParameter.getFiledName();
        boolean simpleFiled = true;
        for (String string : replaceSymbol) {
            // 主要是判断运算符后面的参数是否为字段名,还得去除前面的空格,如果是数字,则不用添加表名
            if (tempField.contains(string)) {
                String[] tempFiledSplitBySymbol = tempField
                        .split("//" + string);
                tempField = tempFiledSplitBySymbol[0] + string;
                for (int i = 1; i < tempFiledSplitBySymbol.length; i++) {
                    if (firstIsLetter(tempFiledSplitBySymbol[i].trim())) {
                        if (!tempFiledSplitBySymbol[i].trim().startsWith(
                                "sfb_divfloat_1")
                                && !tempFiledSplitBySymbol[i].trim()
                                .startsWith("round"))
                            tempField += tableName + "."
                                    + tempFiledSplitBySymbol[i].trim() + string;
                        else
                            tempField += tempFiledSplitBySymbol[i].trim()
                                    + string;
                    } else
                        tempField += tempFiledSplitBySymbol[i].trim() + string;
                }
                tempField = tempField.substring(0, tempField.length() - 1);
            }
            simpleFiled = false;
        }
        if (simpleFiled)
            tempField = rnopMnoParameter.getTableName() + "."
                    + rnopMnoParameter.getFiledName();
        if (rnopMnoParameter.getIsPercent() == 1) { // 增加截取精度两位小数,如果指标为百分比,则乘以100
            tempField = "round(" + tempField + " * 100,2) ";
        } else {
            tempField = "round(" + tempField + ",2) ";
        }
        return fieldName += tempField;
    }

    /*
     * 获取规划图层相关业务信息
     */
    public HashMap<String, Object> GetTableFieldPlan(NETechnology ne, String id,
                                                     ArrayList<RnopMnoParameter> listRnopMnoParameter) {

        String fieldName = "", tableName = "";
        ArrayList<String> distinctTableName = new ArrayList<String>();
        int i = 0;
        for (RnopMnoParameter rnopMnoParameter : listRnopMnoParameter) {
            if (!distinctTableName.contains(rnopMnoParameter.getTableName().toLowerCase())) {
                distinctTableName.add(rnopMnoParameter.getTableName().toLowerCase());
            }

            fieldName = this.getFiledName(fieldName, rnopMnoParameter);
        }

        // 去除最后一个,
        fieldName = fieldName.substring(0, fieldName.length() - 1);

        for (String string : distinctTableName) {
            tableName += string + ",";
        }

        // 去除最后一个,
        tableName = tableName.substring(0, tableName.length() - 1);

        if(ne == NETechnology.PLANDM){
            tableName += " where int_id = " + id;
        }
        else{
            tableName += " where id = " + id;
        }

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("tableName", tableName);
        result.put("fieldName", fieldName);
        return result;

    }

    /*
     * 获取基站信息
     */
    public HashMap<String, Object> GetEnodebTableFieldPlan(NETechnology ne, String id,
                                                           ArrayList<RnopMnoParameter> listRnopMnoParameter) {

        String fieldName = "", tableName = "";
        ArrayList<String> distinctTableName = new ArrayList<String>();
        int i = 0;
        for (RnopMnoParameter rnopMnoParameter : listRnopMnoParameter) {
            if (!distinctTableName.contains(rnopMnoParameter.getTableName().toLowerCase())) {
                distinctTableName.add(rnopMnoParameter.getTableName().toLowerCase());
            }

            fieldName = this.getFiledName(fieldName, rnopMnoParameter);
        }

        // 去除最后一个,
        fieldName = fieldName.substring(0, fieldName.length() - 1);

        for (String string : distinctTableName) {
            if(string.equals("region_city")){
                continue;
            }
            tableName += string + ",";
        }

        // 去除最后一个,
        tableName = tableName.substring(0, tableName.length() - 1);
        tableName += ",region_city";

        tableName += " where int_id = " + id ;

        if(ne == NETechnology.LTE){
            tableName += " and region_city.city_id = enodeb.city_id ";
        }
        if(ne == NETechnology.GSM){
            tableName += " and  region_city.city_id = bts.city_id  ";
        }
        if(ne == NETechnology.TD){
            tableName += " and  region_city.city_id = nodeb.city_id ";
        }


        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("tableName", tableName);
        result.put("fieldName", fieldName);
        return result;

    }

    /**
     * 判断字符串首字符是否为数字
     *
     * @param str
     *            字符串
     * @return true 数字；false 字符
     */
    public static boolean firstIsNumber(String str) {
        char chr = str.charAt(0);
        if (chr < 48 || chr > 57)
            return false;
        return true;
    }

    /**
     * 判断字符串首字符是否为字符
     *
     * @param str
     *            字符串
     * @return true 字符；false 数字
     */
    public static boolean firstIsLetter(String str) {
        char chr = str.charAt(0);
        if ((chr > 64 && chr < 91) || (chr > 96 && chr < 123))
            return true;
        return false;
    }
}
