package com.example.service.excel.excelDemo;

import com.example.service.excel.ExcelException;
import com.example.service.excel.ExcelImporter;
import com.example.service.excel.ExcelParams;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * title：ExcelImporterDemo
 * description:
 *
 * @author yumengjie
 * @date 2019/12/3 10:52
 */

public class ExcelImporterDemo {

    public List<Long> importUserPhoneNumberFile(MultipartFile file) throws IOException, ExcelException {
        LinkedHashMap<String, String> fileMap = new LinkedHashMap();
        fileMap.put("电话号码", "phoneNumber");
        ExcelParams<UserPhoneNumberEntity> param = new ExcelParams(file.getOriginalFilename(), file.getInputStream(), fileMap);
        param.setEntityClass(UserPhoneNumberEntity.class);
        List<UserPhoneNumberEntity> userPhoneNumberList = ExcelImporter.excelToList(param);
        return userPhoneNumberList.stream().map(UserPhoneNumberEntity::getPhoneNumber).collect(Collectors.toList());
    }
}