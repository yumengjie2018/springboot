package com.boco.jlappservice.enums;

public enum NETechnology {
    NONE(0),
    PLANDM(99990),//规划-需求
    PLANFS(99991),//规划-可研
    PLANDG(99992),//规划-设计
    GSM(1), // 2G
    GSM900(100),
    GSM1800(101),
    TD(2), // 3G
    CDMA2000(4), // 2G/3G
    LTE(8), // 4G
    LTETDD(16),//TDD4G
    LTEFDD (32); // FDD4G
    private int value;

    NETechnology(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
