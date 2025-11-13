package com.javahut.menu;
//these enums were created for a quicker call out when i call an order

public enum DrinkCategory {
    COFFEE("Coffee"),
    SMOOTHIE("Smoothie"),
    WATER("Water");

    private final String label;

    DrinkCategory(String label) {
        this.label = label;
    }

    public String label(){
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
