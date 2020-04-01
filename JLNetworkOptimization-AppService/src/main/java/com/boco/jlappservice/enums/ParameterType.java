package com.boco.jlappservice.enums;

public enum ParameterType {
    tcoparameter(0), performance(1),para(2),alarm(3),structureindex(4);
    ParameterType(int value) {
        this.value = value;
    }
    private int value;
    public int getValue() {
        return value;
    }
}
