package com.javahut.menu;

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
