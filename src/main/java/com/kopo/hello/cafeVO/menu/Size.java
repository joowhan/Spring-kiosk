package com.kopo.hello.cafeVO.menu;

public enum Size {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L");

    private final String label;

    Size(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
