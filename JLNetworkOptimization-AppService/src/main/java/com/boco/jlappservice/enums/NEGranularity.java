package com.boco.jlappservice.enums;


/**
 * title：NEGranularity
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 16:26
 */
public enum NEGranularity {
    Province(10000),
    Region(10003),
    City(10004),
    Cell(300), // 2G小区
    BTS(201), // 2G基站
    UtranCell(9300), // 3G小区
    Nodeb(9201), // 3G基站
    Eutrancell(8105), // 4G小区
    ENodeB(8104),
    Temp(0); // 4G基站
    private int value;

    NEGranularity(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}