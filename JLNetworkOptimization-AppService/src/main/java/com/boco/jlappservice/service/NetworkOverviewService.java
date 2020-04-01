package com.boco.jlappservice.service;

import com.boco.jlappservice.entity.request.NetworkOverviewRequest;
import com.boco.jlappservice.entity.response.NetworkOverviewResponse;

import java.util.ArrayList;

public interface NetworkOverviewService {
    ArrayList<NetworkOverviewResponse> getNetworkOverview(NetworkOverviewRequest request);
}
