package com.boco.jlappservice.mapper;

import com.boco.jlappservice.entity.request.DeleteLogRequest;
import com.boco.jlappservice.entity.request.UploadFtpSpeedRequest;
import com.boco.jlappservice.entity.response.FtpSpeedResponse;
import com.boco.jlappservice.entity.response.LogResponse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * title：UploadMapper
 * description:
 *
 * @author yumengjie
 * @date 2020/3/24 9:22
 */

public interface UploadMapper {

    void insertLogFiles(HashMap<String,Object> map);

    int deleteLog(DeleteLogRequest request);

    ArrayList<LogResponse> getLog(String userId);

    int uploadFtpSpeed(UploadFtpSpeedRequest request);

    ArrayList<FtpSpeedResponse> getFtpSpeed(String userId);
}