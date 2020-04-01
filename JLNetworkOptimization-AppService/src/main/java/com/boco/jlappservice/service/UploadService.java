package com.boco.jlappservice.service;

import com.boco.jlappservice.entity.request.DeleteLogRequest;
import com.boco.jlappservice.entity.request.UploadFtpSpeedRequest;
import com.boco.jlappservice.entity.response.FtpSpeedResponse;
import com.boco.jlappservice.entity.response.LogResponse;
import com.boco.jlappservice.entity.response.ResponseMessage2;
import com.boco.jlappservice.entity.response.UploadLogResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

/**
 * title：UploadService
 * description:
 *
 * @author yumengjie
 * @date 2020/3/24 9:21
 */

public interface UploadService {

    String uploadLog(HttpServletRequest req, MultipartFile file)  throws IOException;

    Integer deleteLog(DeleteLogRequest request);

    ArrayList<LogResponse> getLog(String userId);

    Integer uploadFtpSpeed(UploadFtpSpeedRequest request);

    ArrayList<FtpSpeedResponse> getFtpSpeed(String userId);
}