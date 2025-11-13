package com.javahut.menu;

public enum SpecialOption {
    NONE("None"),
    FILLING_CREAM("Cream Filling"),
    FILLING_JELLY("Jelly Filling");

    private final String label;

    SpecialOption(String label) {
        this.label = label;
    }

    public String label(){
        return label;
    }

    @Override
    public String toString(){
        return label;
    }
}
