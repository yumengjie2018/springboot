package com.boco.jlappservice.service.impl;

import com.boco.jlappservice.service.AppVersionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * title：AppVersionServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2020/3/23 9:44
 */
@Service
public class AppVersionServiceImpl implements AppVersionService {

    private static final String QR_CODE_URL = "/upload/QRCode/load.png";
    @Value("${publicServer.address}")
    private String serviceAddress;
    @Override
    public String getQRCodeURL() {
        String resultInit = serviceAddress+ QR_CODE_URL;
        return resultInit;
    }
}