package com.boco.jlappservice.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boco.jlappservice.entity.domainModel.BaseInformationEntity;
import com.boco.jlappservice.entity.domainModel.DetailInformationEntity;
import com.boco.jlappservice.entity.domainModel.GisCellsList;
import com.boco.jlappservice.entity.request.GetAdjacentCellRequest;
import com.boco.jlappservice.entity.request.GetCellsByIdRequest;
import com.boco.jlappservice.entity.request.GetGeoCellsByRegionRequest;
import com.boco.jlappservice.entity.response.ArrayCommonResponse;
import com.boco.jlappservice.entity.response.GetGeoCellsByRegionResponse;
import com.boco.jlappservice.entity.response.ResponseMessage2;
import com.boco.jlappservice.service.YnGisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * title：YnGisController
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 19:45
 */
@RestController
@RequestMapping("/api/gis")
@Api(tags="gis接口列表")
public class YnGisController {
    @Autowired
    private YnGisService service;
    @GetMapping(value = "/GetCellsList")
    @ApiOperation("通过小区ID和网络制式获取同站小区")
    public ResponseMessage2<ArrayCommonResponse<GisCellsList>> GetCellsList(GetCellsByIdRequest request) throws Exception {
        return ResponseMessage2.Success2(service.GetCellsList(request));
    }
    @GetMapping(value = "/GetGeoCellsByRegion")
    @ApiOperation(value = "经纬度范围获取地理小区")
    public ResponseMessage2<GetGeoCellsByRegionResponse> GetGeoCellsByRegion(GetGeoCellsByRegionRequest request){
        return ResponseMessage2.Success2(service.GetGeoCellsByRegion(request));
    }
    @GetMapping(value = "/GetAdjacentResources")
    @ApiOperation("gis模块取邻区资源信息")
    public ResponseMessage2<GetGeoCellsByRegionResponse> GetAdjacentResources(GetAdjacentCellRequest request){
        return ResponseMessage2.Success2(service.GetAdjacentResources(request));
    }
}