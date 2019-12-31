//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.service.excel;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

public class ExcelImporter {
    public ExcelImporter() {
    }

    public static <T> List<T> excelToList(ExcelParams<T> params) throws ExcelException {
        List<T> resultList = new ArrayList();
        LinkedHashMap<String, String> fieldMap = params.getFieldMap();
        Class<T> entityClass = params.getEntityClass();
        String dateformat = params.getDateformat();

        try {
            Sheet[] sheets = getSheet(params);
            Sheet sheet = sheets[0];
            int realRows = getRealRow(sheet);
            Row firstRow = sheet.getRow(0);
            String[] excelFieldNames = getFiledList(firstRow, fieldMap);
            LinkedHashMap<String, Integer> colMap = new LinkedHashMap();

            int i;
            for(i = 0; i < excelFieldNames.length; ++i) {
                colMap.put(excelFieldNames[i], firstRow.getCell(i).getColumnIndex());
            }

            for(i = 1; i <= realRows; ++i) {
                T entity = entityClass.newInstance();
                Row row2 = sheet.getRow(i);
                Iterator var14 = fieldMap.entrySet().iterator();

                while(var14.hasNext()) {
                    Entry<String, String> entry = (Entry)var14.next();
                    String cnNormalName = (String)entry.getKey();
                    String enNormalName = (String)entry.getValue();
                    int col = (Integer)colMap.get(cnNormalName);
                    String content = getCellValueByCell(row2.getCell(col));
                    FieldUtil.setFieldValueByName(enNormalName, content, entity, dateformat);
                }

                resultList.add(entity);
            }

            return resultList;
        } catch (Exception var20) {
            var20.printStackTrace();
            if (var20 instanceof ExcelException) {
                throw (ExcelException)var20;
            } else {
                var20.printStackTrace();
                throw new ExcelException("导入Excel失败" + var20.getMessage());
            }
        }
    }

    private static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            wb = new HSSFWorkbook(inStr);
        } else {
            if (!".xlsx".equals(fileType) && !".csv".equals(fileType)) {
                throw new ExcelException("解析的文件格式有误！" + fileType);
            }

            wb = new XSSFWorkbook(inStr);
        }

        return (Workbook)wb;
    }

    private static <T> Sheet[] getSheet(ExcelParams<T> params) throws Exception {
        String fileName = params.getFileName();
        InputStream in = params.getInputStream();
        if (params.getInputStream() == null) {
            in = new FileInputStream(fileName);
        }

        Workbook wb = getWorkbook((InputStream)in, fileName);
        String sheetName = params.getSheetName();
        int sheetsize = wb.getNumberOfSheets();
        Sheet[] sheet = new Sheet[sheetsize];
        if (sheetName != null && !sheetName.trim().equals("")) {
            sheet[0] = wb.getSheet(sheetName);
        } else {
            for(int i = 0; i < sheetsize; ++i) {
                sheet[i] = wb.getSheetAt(i);
            }
        }

        ((InputStream)in).close();
        return sheet;
    }

    private static int getRealRow(Sheet sheet) throws ExcelException {
        int realRows = 0;
        if (sheet.getLastRowNum() == 1) {
            return 1;
        } else {
            for(int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); ++i) {
                int nullCols = 0;
                Row row = sheet.getRow(i);
                if (row == null) {
                    break;
                }

                for(int j = 0; j <= row.getLastCellNum(); ++j) {
                    Cell currentCell = row.getCell(j);
                    String cellValue = getCellValueByCell(currentCell);
                    if (currentCell == null || "".equals(cellValue)) {
                        ++nullCols;
                    }
                }

                if (nullCols == row.getLastCellNum() - row.getFirstCellNum()) {
                    break;
                }

                ++realRows;
            }

            if (realRows <= 1) {
                throw new ExcelException("Excel文件中没有任何数据");
            } else {
                return realRows - 1;
            }
        }
    }

    private static String[] getFiledList(Row firstRow, LinkedHashMap<String, String> fieldMap) throws ExcelException {
        int length = firstRow.getLastCellNum() - firstRow.getFirstCellNum();
        String[] excelFieldNames = new String[length];

        for(int i = 0; i < length; ++i) {
            if (firstRow.getCell(i).getStringCellValue() == null) {
                excelFieldNames[i] = "";
            }

            excelFieldNames[i] = firstRow.getCell(i).getStringCellValue().replaceAll(" ", "");
        }

        boolean isExist = true;
        List<String> excelFieldList = Arrays.asList(excelFieldNames);
        StringBuilder msg = new StringBuilder();
        Iterator var7 = fieldMap.entrySet().iterator();

        while(var7.hasNext()) {
            Entry<String, String> entry = (Entry)var7.next();
            String cnName = (String)entry.getKey();
            if (!excelFieldList.contains(cnName)) {
                isExist = false;
                msg.append(cnName + ",");
            }
        }

        if (!isExist) {
            throw new ExcelException("Excel中缺少必要的字段[" + msg.toString().substring(0, msg.length() - 1) + "]");
        } else {
            return excelFieldNames;
        }
    }

    private static String getCellValueByCell(Cell cell) {
        if (cell != null && !cell.toString().trim().equals("")) {
            String cellValue = "";
            CellType cellType = cell.getCellTypeEnum();
            switch(cellType) {
                case STRING:
                    cellValue = cell.getStringCellValue().trim();
                    cellValue = StringUtils.isEmpty(cellValue) ? "" : cellValue;
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        cellValue = DateTime.format(cell.getDateCellValue());
                    } else {
                        cellValue = (new DecimalFormat("#.######")).format(cell.getNumericCellValue());
                    }
                    break;
                default:
                    cellValue = "";
            }

            return cellValue;
        } else {
            return "";
        }
    }
}
