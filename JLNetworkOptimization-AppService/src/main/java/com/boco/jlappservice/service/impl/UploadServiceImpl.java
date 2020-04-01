package com.boco.jlappservice.service.impl;

import com.boco.jlappservice.entity.request.DeleteLogRequest;
import com.boco.jlappservice.entity.request.UploadFtpSpeedRequest;
import com.boco.jlappservice.entity.response.FtpSpeedResponse;
import com.boco.jlappservice.entity.response.LogResponse;
import com.boco.jlappservice.entity.response.UploadLogResponse;
import com.boco.jlappservice.mapper.UploadMapper;
import com.boco.jlappservice.service.UploadService;
import com.boco.jlappservice.utility.FileHandleUtil;
import com.boco.jlappservice.utility.TimeConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * title：UploadServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2020/3/24 9:21
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Value("${publicServer.address}")
    private String serviceAddress;
    @Autowired
    private UploadMapper mapper;
    @Override
    public String uploadLog(HttpServletRequest req, MultipartFile file) throws IOException {
        // 生成编号
        String number = TimeConvertor.getSerialNumber();
        //设置路径（static文件夹/upload/headImages/UserId）(static文件夹与jar包同级)
        String referDir = File.separator+"upload"+File.separator+"log"+File.separator+ req.getHeader("userId");
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(),"static"+referDir);
        if(!upload.exists()) {
            upload.mkdirs();
        }
        String dir=upload.getPath();
        String fileName = file.getOriginalFilename();
        fileName = "道路覆盖测试_"+number + fileName.substring(fileName.lastIndexOf('.'), fileName.length());
        file.transferTo(new File(dir, fileName));
        //向数据库插入图片路径信息（相对路径）
        String filePath = referDir + File.separator + fileName;
        //为了之后URL可以访问到，统一改为"/"
        filePath = serviceAddress+filePath.replaceAll("\\\\", "\\/");
        HashMap<String,Object> map=new HashMap<>();
        map.put("userId",req.getHeader("userId"));
        map.put("filePath",filePath);
        map.put("insertTime",TimeConvertor.getTodayTime());
        fileName=fileName.substring(0,fileName.indexOf('.'));
        map.put("fileName",fileName);
        mapper.insertLogFiles(map);
        return filePath;
    }
    @Override
    public Integer deleteLog(DeleteLogRequest request) {
     return mapper.deleteLog(request);
    }

    @Override
    public ArrayList<LogResponse> getLog(String userId) {
        return mapper.getLog(userId);
    }

    @Override
    public Integer uploadFtpSpeed(UploadFtpSpeedRequest request) {
        return mapper.uploadFtpSpeed(request);
    }

    @Override
    public ArrayList<FtpSpeedResponse> getFtpSpeed(String userId) {
        return mapper.getFtpSpeed(userId);
    }

}