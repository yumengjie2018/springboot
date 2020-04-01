package com.boco.jlappservice.controller;

/**
 * title：CellAnalysisController
 * description:小区资源接口列表
 *
 * @author yumengjie
 * @date 2020/3/7 16:13
 */

import com.boco.jlappservice.entity.request.*;
import com.boco.jlappservice.entity.response.*;
import com.boco.jlappservice.service.CellAnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/cellanalysis")
@Api(tags="小区资源接口列表")
public class CellAnalysisController {
    @Autowired
    private CellAnalysisService service;

//    @GetMapping(value = "/GetPlanResource")
//    @ApiOperation("获取规划图层相关业务信息")
//    public ResponseMessage2<GetCellParametersResponse> getPlanResource(GetCellParametersRequest request) {
//        return ResponseMessage2.Success2(service.getPlanResource(request));
//    }
    @GetMapping(value = "/GetCellParameters")
    @ApiOperation("通过网元编号、制式获取网元工参")
    public ResponseMessage2<GetCellParametersResponse> GetCellParameters(GetCellParametersRequest request) {
        return ResponseMessage2.Success2(service.GetCellParameters(request));
    }
    @GetMapping(value = "/GetCellPerformance")
    @ApiOperation("通过网元编号、制式获取网元性能")
    public ResponseMessage2<GetCellPerformanceResponse> GetCellPerformance(GetCellPerformanceRequest request) {
        return ResponseMessage2.Success2(service.GetCellPerformance(request));
    }
    @GetMapping(value = "/GetCellPara")
    @ApiOperation("通过网元编号、制式获取网元参数")
    public ResponseMessage2<GetCellParaResponse> GetCellPara(GetCellParaRequest request){
        return ResponseMessage2.Success2(service.GetCellPara(request));
    }
    @GetMapping(value = "/GetAdjacentCell")
    @ApiOperation("通过网元编号、制式获取邻区列表")
    public ResponseMessage2<GetAdjacentCellResponse> GetAdjacentCell(GetAdjacentCellRequest request) {
        return ResponseMessage2.Success2(service.GetAdjacentCell(request));
    }
    @GetMapping(value = "/GetCellAlarm")
    @ApiOperation("通过网元编号、制式获取网元告警")
    public ResponseMessage2<GetCellAlarmResponse> GetCellAlarm(GetCellAlarmRequest request)
    {
        return ResponseMessage2.Success2(service.GetCellAlarm(request));
    }
    @GetMapping(value = "/GetCellsByName")
    @ApiOperation("通过名称查询小区(提供分页)")
    public ResponseMessage2<GetCellsByNameResponse> GetCellsByName(GetCellsByNameRequest request)
    {
        return ResponseMessage2.Success2(service.GetCellsByName(request));
    }
    @GetMapping(value = "/GetResourceIdByCgi")
    @ApiOperation("通过网元编号、制式获取结构指标")
    public ResponseMessage2<GetGeoCellsByRegionResponse> GetResourceIdByCgi(String cgi) {
        return ResponseMessage2.Success2(service.GetResourceIdByCgi(cgi));
    }

    @GetMapping(value = "/GetCellAnalysis")
    @ApiOperation("通过小区名称模糊搜索小区分析")
    public ResponseMessage2<ArrayList<CellAnalysisResponse>> GetCellAnalysis(CellAnalysisRequest request) {
        return ResponseMessage2.Success2(service.GetCellAnalysis(request));
    }


}