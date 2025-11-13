package com.javahut.menu;
//these enums were created for a quicker call out when i call an order

public enum DonutType {
    YEAST("Yeast"),
    CAKE("Cake"),
    MOCHI("Mochi");

    private final String label;

    DonutType(String label) {
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
