package com.javahut.menu;
//these enums were created for a quicker call out when i call an order

public enum DrinkSize {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String label;
    DrinkSize(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
