package com.boco.jlappservice.utility;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * title：UploadMultipartFiles
 * description:
 *
 * @author yumengjie
 * @date 2020/3/24 10:06
 */

public class UploadMultipartFiles {

    public static List<String> execute(String dir, String referDir, MultipartFile[] files) throws IOException {
        List<String> attachFiles = new ArrayList<>();
        Integer fileNumber = 0;
        for (MultipartFile file : files) {

            //保存文件(重命名，避免超出加密长度限制)
            String fileName = file.getOriginalFilename();
            fileName = fileNumber.toString() + fileName.substring(fileName.lastIndexOf('.'), fileName.length());
            file.transferTo(new File(dir, fileName));

            //文件相对路径
            String filePath = referDir + File.separator + fileName;
            //为了之后URL可以访问到，统一改为"/"
            filePath = filePath.replaceAll("\\\\","\\/");
            attachFiles.add(filePath);
            fileNumber++;
        }
        return attachFiles;
    }


}