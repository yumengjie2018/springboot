package com.boco.jlappservice.controller;

import com.boco.jlappservice.entity.request.NetworkOverviewRequest;
import com.boco.jlappservice.entity.response.LogResponse;
import com.boco.jlappservice.entity.response.NetworkOverviewResponse;
import com.boco.jlappservice.entity.response.ResponseMessage2;
import com.boco.jlappservice.service.NetworkOverviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * title：NetworkOverview
 * description:网络概况
 *
 * @author yumengjie
 * @date 2020/3/26 13:19
 */
@RestController
@RequestMapping(value = "/app/networkOverview")
@Api(tags = "网络概况")
public class NetworkOverviewController {
    @Autowired
    private NetworkOverviewService service;
    @GetMapping(value = "/getNetworkOverview")
    @ApiOperation(value = "查看LTE或GSM网络概况")
    public ResponseMessage2<ArrayList<NetworkOverviewResponse>> getNetworkOverview(NetworkOverviewRequest request) {
        return ResponseMessage2.Success2(service.getNetworkOverview(request));
    }
}