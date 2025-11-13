package com.javahut.menu;

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
