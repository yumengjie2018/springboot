package com.boco.jlappservice.enums;

public enum SumLevel {
    Hour(0),Day(1),Week(2),Month(3),Tem(11);
    private SumLevel(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
