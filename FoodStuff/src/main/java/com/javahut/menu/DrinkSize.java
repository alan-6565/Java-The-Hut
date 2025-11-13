package com.javahut.menu;

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
