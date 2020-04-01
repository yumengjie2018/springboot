package com.boco.jlappservice.enums;

public enum ReportFormType {
    lteparametervalue(4),ltesubframeallocation(5),tdtolteadjacent(1),ltetotdadjacent(2),ltetogsmajacent(3),lteparameterquery(6);
    ReportFormType(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}
