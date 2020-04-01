package com.boco.jlappservice.controller;

import com.boco.jlappservice.entity.request.DeleteLogRequest;
import com.boco.jlappservice.entity.request.UploadFtpSpeedRequest;
import com.boco.jlappservice.entity.response.FtpSpeedResponse;
import com.boco.jlappservice.entity.response.LogResponse;
import com.boco.jlappservice.entity.response.ResponseMessage2;
import com.boco.jlappservice.entity.response.UploadLogResponse;
import com.boco.jlappservice.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

/**
 * title：UploadController
 * description:上传接口
 *
 * @author yumengjie
 * @date 2020/3/24 9:19
 */
@RestController
@RequestMapping(value = "/api/upload")
@Api(tags = "上传接口")
public class UploadController {
    @Autowired
    private UploadService service;
    @GetMapping(value = "/getLog")
    @ApiOperation(value = "查看日志文件")
    public ResponseMessage2<ArrayList<LogResponse>> getLog(HttpServletRequest request) {
        return ResponseMessage2.Success2(service.getLog(request.getHeader("userId")));
    }
    @PostMapping(value = "/uploadLog")
    @ApiOperation(value = "上传日志文件")
    public ResponseMessage2<String> uploadLog(HttpServletRequest req, MultipartFile file)  throws IOException {
        return ResponseMessage2.Success2(service.uploadLog(req,file));
    }
    @PostMapping(value = "/deleteLog")
    @ApiOperation(value = "删除日志文件")
    public ResponseMessage2<Integer> deleteLog(@RequestBody DeleteLogRequest request) {
        return ResponseMessage2.Success2(service.deleteLog(request));
    }
    @PostMapping(value = "/uploadFtpSpeed")
    @ApiOperation(value = "上传ftp上传下载速率")
    public ResponseMessage2<Integer> uploadFtpSpeed(@RequestBody UploadFtpSpeedRequest request) {
        return ResponseMessage2.Success2(service.uploadFtpSpeed(request));
    }
    @GetMapping(value = "/getFtpSpeed")
    @ApiOperation(value = "查看ftp上传下载速率")
    public ResponseMessage2<ArrayList<FtpSpeedResponse>> getFtpSpeed(HttpServletRequest request) {
        return ResponseMessage2.Success2(service.getFtpSpeed(request.getHeader("userId")));
    }

}