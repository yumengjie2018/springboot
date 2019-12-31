package com.example.service.excel.excelDemo;

import com.example.service.excel.ExcelException;
import com.example.service.excel.ExcelExporter;
import com.example.service.excel.ExcelParams;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.collections.FastArrayList;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * title：ExcelExporterDemo
 * description:
 *
 * @author yumengjie
 * @date 2019/12/3 10:54
 */

public class ExcelExporterDemo {

    public void exportRegionMobileInternetByParam( HttpServletResponse response) throws ExcelException, IOException {
        List<RegionMobileInternetEntity> regionMobileList = new ArrayList();
//        LinkedHashMap<String, String> fieldMap = getStringStringLinkedHashMap();
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("statisticalTime", "时间");
        fieldMap.put("regionName", "地市/省");
        fieldMap.put("mobileScore", "手机上网得分");
        fieldMap.put("unsatisfactoryProportion", "手机上网不满意占比");
        fieldMap.put("unsatisfactoryUsers", "手机上网不满意用户数");
        ExcelParams<RegionMobileInternetEntity> params = new ExcelParams<>("地市维度手机上网得分统计.xlsx", fieldMap);
        params.setList(regionMobileList);
        ExcelExporter.listToExcel(params, response);
    }
//    /**
//     * 表头公共部分
//     *
//     * @return
//     */
//    private LinkedHashMap<String, String> getStringStringLinkedHashMap() {
//        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
//        fieldMap.put("statisticalTime", "时间");
//        fieldMap.put("regionName", "地市/省");
//        return fieldMap;
//    }
}