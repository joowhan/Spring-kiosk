package com.kopo.cafe.global.enums;

public enum SizeEnum {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L");

    private final String label;

    SizeEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
