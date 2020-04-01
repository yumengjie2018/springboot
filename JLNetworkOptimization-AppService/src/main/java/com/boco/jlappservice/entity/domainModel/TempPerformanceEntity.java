package com.boco.jlappservice.entity.domainModel;

import lombok.Data;

/**
 * title：TempPerformanceEntity
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 18:37
 */
@Data
public class TempPerformanceEntity {

    private double rrcNum;
    private double upPrb;
    private double downPrb;
    private double volteLose;
    private double volteNum;
    private double esrvcc;
    private double MrCover;
}