package com.javahut.menu;
//these enums were created for a quicker call out when i call an order

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
