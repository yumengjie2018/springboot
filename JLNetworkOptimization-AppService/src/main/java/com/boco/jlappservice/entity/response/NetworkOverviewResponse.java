package com.boco.jlappservice.entity.response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：NetworkOverviewResponse
 * description:网络概况
 *
 * @author yumengjie
 * @date 2020/3/26 13:25
 */
@Data
public class NetworkOverviewResponse {
    @ApiModelProperty(value = "地市名称")
    private String name;
    @ApiModelProperty(value = "基站数")
    private long siteNbr;
    @ApiModelProperty(value = "小区数")
    private long cellNbr;
    @ApiModelProperty(value = "无线接通率")
    private double wirelessConnectivity;
    @ApiModelProperty(value = "无线接通率QCI=1")
    private double wirelessConnectivityQCI;
    @ApiModelProperty(value = "无线掉线率")
    private double wirelessDropRate;
    @ApiModelProperty(value = "E-RAB掉线率(小区级)")
    private double erabDropRate;
    @ApiModelProperty(value = "E-RAB掉线率(QCI=1)(小区级)")
    private double erabDropRateQCI;
    @ApiModelProperty(value = "切换成功率")
    private double switchingSuccessRate;
    @ApiModelProperty(value = "eSRVCC无线切换成功率")
    private double esrvccSwitchingSuccessRate;
    @ApiModelProperty(value = "上行PRB利用率")
    private double upPrbUtilization;
    @ApiModelProperty(value = "下行PRB利用率")
    private double downPrbUtilization;
    @ApiModelProperty(value = "VoLTE上行丢包率")
    private double volteUpPacketLossRate;
    @ApiModelProperty(value = "VoLTE下行丢包率")
    private double volteDownPacketLossRate;
    @ApiModelProperty(value = "VOLTE语音话务量(万Erl)")
    private double volteVoiceCallVolume;
    @ApiModelProperty(value = "流量TB")
    private double flow;
    @ApiModelProperty(value = "MR覆盖率")
    private double mrCoverage;
    @ApiModelProperty(value = "话务量(万Erl)")
    private double gsmVoiceCallVolume;
    @ApiModelProperty(value = "数据流量(TB)")
    private double gsmDataFlow;
    @ApiModelProperty(value = "无线利用率")
    private double gsmWirelessUtilization;
    @ApiModelProperty(value = "TCH拥塞率(不含切)")
    private double gsmTchCongestionRate;
    @ApiModelProperty(value = "掉话率")
    private double gsmCallDropRate;

}