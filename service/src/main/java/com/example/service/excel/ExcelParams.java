//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.service.excel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;

public class ExcelParams<T> {
    static final String excel2003L = ".xls";
    static final String excel2007U = ".xlsx";
    private List<T> list;
    private Class<T> entityClass;
    private OutputStream outputStream;
    private InputStream inputStream;
    private String fileName;
    private String sheetName;
    private LinkedHashMap<String, String> fieldMap;
    private int sheetSize;
    private String dateformat;

    public ExcelParams(String fileName, LinkedHashMap<String, String> fieldMap) throws IOException {
        this.fileName = fileName;
        this.fieldMap = fieldMap;
    }

    public ExcelParams(String fileName, InputStream inputStreamParam, LinkedHashMap<String, String> fieldMap) throws IOException {
        this.fileName = fileName;
        this.fieldMap = fieldMap;
        this.inputStream = inputStreamParam;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Class<T> getEntityClass() {
        return this.entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getSheetName() {
        return this.sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public LinkedHashMap<String, String> getFieldMap() {
        return this.fieldMap;
    }

    public void setFieldMap(LinkedHashMap<String, String> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public int getSheetSize() {
        return this.sheetSize;
    }

    public void setSheetSize(int sheetSize) {
        this.sheetSize = sheetSize;
    }

    public String getDateformat() {
        return this.dateformat;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }
}
