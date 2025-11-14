package com.javahut.menu;
//these enums were created for a quicker call out when i call an order
public enum DonutSize {
    MINI_BITE("1 Donut"),
    CLASSIC("Half a Dozen"),
    JUMBO("Dozen");

    private final String label;

    DonutSize(String label) {
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
