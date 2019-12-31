//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.service.excel;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.reflect.MethodUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.*;
import java.util.Map.Entry;

public class ExcelExporter {
    private static Integer largeSize = 20000;

    public ExcelExporter() {
    }

    public static <T> void listToExcel(ExcelParams<T> params, HttpServletResponse response) throws ExcelException {
        String fileName = params.getFileName();
        ServletOutputStream out = null;

        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
            out = response.getOutputStream();
            params.setOutputStream(out);
            listToExcel(params);
        } catch (Exception var5) {
            var5.printStackTrace();
            if (var5 instanceof ExcelException) {
                throw (ExcelException)var5;
            } else {
                throw new ExcelException("导出Excel失败");
            }
        }
    }

    public static <T> void listToFile(ExcelParams<T> params) {
        try {
            String fileName = params.getFileName();
            OutputStream outputStream = new FileOutputStream(fileName);
            params.setOutputStream(outputStream);
            listToExcel(params);
            outputStream = params.getOutputStream();
            outputStream.flush();
            outputStream.close();
        } catch (IOException | ExcelException var3) {
            var3.printStackTrace();
        }

    }

    public static <T> InputStream listToExcelInputStream(ExcelParams<T> params) throws ExcelException {
        List<T> list = params.getList();
        String fileName = params.getFileName();
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        String sheetName = params.getSheetName();
        OutputStream os = new ByteArrayOutputStream();
        int sheetSize = params.getSheetSize();
        LinkedHashMap<String, String> fieldMap = params.getFieldMap();
        if (sheetName == null || sheetName.equals("")) {
            sheetName = "sheet";
        }

        if (fileType.equals(".xls")) {
            sheetSize = 65535;
        }

        try {
            Workbook wwb = getWorkbook(fileName, list.size());
            if (sheetSize > 0 && Math.ceil((double)list.size() / (new Integer(sheetSize)).doubleValue()) > 1.0D) {
                double sheetNum = Math.ceil((double)list.size() / (new Integer(sheetSize)).doubleValue());

                for(int i = 0; (double)i < sheetNum; ++i) {
                    Sheet sheet = wwb.createSheet(sheetName + i);
                    int firstIndex = i * sheetSize;
                    int lastIndex = (i + 1) * sheetSize - 1 > list.size() - 1 ? list.size() - 1 : (i + 1) * sheetSize - 1;
                    fillSheet(wwb, sheet, list, fieldMap, firstIndex, lastIndex, params.getDateformat());
                }
            } else {
                Sheet sheet = wwb.createSheet(sheetName);
                fillSheet(wwb, sheet, list, fieldMap, 0, list.size() - 1, params.getDateformat());
            }

            wwb.write(os);
            new ByteArrayOutputStream();
            ByteArrayOutputStream baos = (ByteArrayOutputStream)os;
            ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
            return swapStream;
        } catch (Exception var15) {
            var15.printStackTrace();
            if (var15 instanceof ExcelException) {
                throw (ExcelException)var15;
            } else {
                throw new ExcelException("创建Excel数据流失败");
            }
        }
    }

    private static <T> void listToExcel(ExcelParams<T> params) throws ExcelException {
        List<T> list = params.getList();
        String fileName = params.getFileName();
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        String sheetName = params.getSheetName();
        OutputStream os = params.getOutputStream();
        int sheetSize = params.getSheetSize();
        LinkedHashMap<String, String> fieldMap = params.getFieldMap();
        if (sheetName == null || sheetName.equals("")) {
            sheetName = "sheet";
        }

        if (fileType.equals(".xls")) {
            sheetSize = 65535;
        }

        Workbook wwb = null;

        try {
            wwb = getWorkbook(fileName, list.size());
            Sheet sheet;
            if (list != null && !list.isEmpty()) {
                if (sheetSize > 0 && Math.ceil((double)list.size() / (new Integer(sheetSize)).doubleValue()) > 1.0D) {
                    double sheetNum = Math.ceil((double)list.size() / (new Integer(sheetSize)).doubleValue());

                    for(int i = 0; (double)i < sheetNum; ++i) {
                        sheet = wwb.createSheet(sheetName + i);
                        int firstIndex = i * sheetSize;
                        int lastIndex = (i + 1) * sheetSize - 1 > list.size() - 1 ? list.size() - 1 : (i + 1) * sheetSize - 1;
                        fillSheet(wwb, sheet, list, fieldMap, firstIndex, lastIndex, params.getDateformat());
                    }
                } else {
                    sheet = wwb.createSheet(sheetName);
                    fillSheet(wwb, sheet, list, fieldMap, 0, list.size() - 1, params.getDateformat());
                }
            } else {
                sheet = wwb.createSheet(sheetName);
                fillSheet(wwb, sheet, (List)null, fieldMap, 0, 0, params.getDateformat());
            }

            wwb.write(os);
            params.setOutputStream(os);
        } catch (Exception var22) {
            var22.printStackTrace();
            if (var22 instanceof ExcelException) {
                throw (ExcelException)var22;
            }

            throw new ExcelException("导出Excel失败");
        } finally {
            if (wwb != null) {
                try {
                    wwb.close();
                } catch (IOException var21) {
                    var21.printStackTrace();
                }
            }

        }

    }

    private static Workbook getWorkbook(String fileName, Integer size) throws ExcelException {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            wb = new HSSFWorkbook();
        } else {
            if (!".xlsx".equals(fileType)) {
                throw new ExcelException("解析的文件格式有误！" + fileName);
            }

            if (size > largeSize) {
                wb = new SXSSFWorkbook(largeSize);
            } else {
                wb = new XSSFWorkbook();
            }
        }

        return (Workbook)wb;
    }

    private static Object getFieldValueByNameSequence(String fieldNameSequence, Object o) throws Exception {
        String[] attributes = fieldNameSequence.split("\\.");
        if (attributes.length == 1) {
            return getAttributeValue(o, fieldNameSequence);
        } else {
            Object fieldObj = getAttributeValue(o, attributes[0]);
            String subFieldNameSequence = fieldNameSequence.substring(fieldNameSequence.indexOf(".") + 1);
            return getFieldValueByNameSequence(subFieldNameSequence, fieldObj);
        }
    }

    private static Object getAttributeValue(Object o, String attribute) throws Exception {
        try {
            return MethodUtils.invokeMethod(o, "get" + capitalize(attribute.trim()), (Object[])null);
        } catch (NoSuchMethodException var3) {
            return FieldUtil.getFieldValueByName(attribute, o);
        }
    }

    private static String getDatePattern(Object o, String attribute) {
        Field field = FieldUtil.getFieldByName(attribute, o.getClass());
        String pattern = "yyyy-MM-dd HH:mm:ss";
        JsonFormat annotation = (JsonFormat)field.getAnnotation(JsonFormat.class);
        if (null != annotation) {
            pattern = annotation.pattern();
        }

        return pattern;
    }

    private static String capitalize(String s) {
        if (s != null && s.length() != 0) {
            if (s.length() > 1 && Character.isUpperCase(s.charAt(1))) {
                return s;
            } else {
                char[] ac = s.toCharArray();
                ac[0] = Character.toUpperCase(ac[0]);
                return new String(ac);
            }
        } else {
            return s;
        }
    }

    private static <T> void fillSheet(Workbook wb, Sheet sheet, List<T> list, LinkedHashMap<String, String> fieldMap, int firstIndex, int lastIndex, String dateformat) throws Exception {
        String[] enFields = new String[fieldMap.size()];
        String[] cnFields = new String[fieldMap.size()];
        CellStyle cellStyle = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("@"));
        int count = 0;

        for(Iterator var12 = fieldMap.entrySet().iterator(); var12.hasNext(); ++count) {
            Entry<String, String> entry = (Entry)var12.next();
            enFields[count] = (String)entry.getKey();
            cnFields[count] = (String)entry.getValue();
        }

        Row row = sheet.createRow(0);

        int rowNo;
        for(rowNo = 0; rowNo < cnFields.length; ++rowNo) {
            Cell cell = row.createCell(rowNo);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(cnFields[rowNo]);
        }

        if (list != null && !list.isEmpty()) {
            rowNo = 1;

            for(int index = firstIndex; index <= lastIndex; ++index) {
                T item = list.get(index);
                Row row1 = sheet.createRow(rowNo);

                for(int i = 0; i < enFields.length; ++i) {
                    Cell cell = row1.createCell(i);
                    cell.setCellStyle(cellStyle);
                    Object objValue;
                    if (item instanceof Map) {
                        objValue = ((Map)item).get(enFields[i]);
                    } else {
                        objValue = getFieldValueByNameSequence(enFields[i].trim(), item);
                    }

                    if (objValue != null && objValue instanceof Date) {
                        if (StringUtils.isBlank(dateformat)) {
                            dateformat = getDatePattern(item, enFields[i].trim());
                        }

                        cell.setCellValue(DateTime.format((Date)objValue, dateformat));
                    } else if (objValue != null && objValue instanceof Double) {
                        cell.setCellValue((Double)objValue);
                    } else if (objValue != null && objValue instanceof Float) {
                        cell.setCellValue(((Float)objValue).doubleValue());
                    } else if (objValue != null && objValue instanceof Integer) {
                        cell.setCellValue((double)(Integer)objValue);
                    } else {
                        cell.setCellValue(objValue == null ? "" : String.valueOf(objValue));
                    }
                }

                ++rowNo;
            }

        }
    }

    private static String big(double d) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return nf.format(d);
    }

    public static void setLargeSize(Integer largeSize) {
        largeSize = largeSize;
    }
}
