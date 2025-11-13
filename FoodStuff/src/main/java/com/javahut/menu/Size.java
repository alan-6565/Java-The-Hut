package com.javahut.menu;

public enum Size {
    MINI_BITE("Mini Bite"),
    CLASSIC("Classic"),
    JUMBO("Jumbo");

    private final String label;

    Size(String label) {
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
