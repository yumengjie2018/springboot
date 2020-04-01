package com.boco.jlappservice.mapper;

import com.boco.jlappservice.entity.request.NetworkOverviewRequest;
import com.boco.jlappservice.entity.response.NetworkOverviewResponse;

import java.util.ArrayList;

public interface NetworkOverviewMapper {
    ArrayList<NetworkOverviewResponse> getLteNetworkOverview(NetworkOverviewRequest request);

    ArrayList<NetworkOverviewResponse> getGsmNetworkOverview(NetworkOverviewRequest request);
}
