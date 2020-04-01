package com.boco.jlappservice.service.impl;

import com.boco.jlappservice.entity.request.NetworkOverviewRequest;
import com.boco.jlappservice.entity.response.NetworkOverviewResponse;
import com.boco.jlappservice.mapper.NetworkOverviewMapper;
import com.boco.jlappservice.service.NetworkOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * title：NetworkOverviewServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2020/3/26 13:21
 */
@Service
public class NetworkOverviewServiceImpl implements NetworkOverviewService {
    @Autowired
    private NetworkOverviewMapper mapper;
    @Override
    public ArrayList<NetworkOverviewResponse> getNetworkOverview(NetworkOverviewRequest request) {
        ArrayList<NetworkOverviewResponse> responses=new ArrayList<>();
        if(request.getNetworkType().equals("LTE")){
            responses=mapper.getLteNetworkOverview(request);
        }else {
            responses=mapper.getGsmNetworkOverview(request);
        }
        return responses;
    }
}