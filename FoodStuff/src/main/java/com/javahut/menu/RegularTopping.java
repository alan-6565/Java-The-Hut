package com.javahut.menu;
//these enums were created for a quicker call out when i call an order

public enum RegularTopping {
    SPRINKLES("Sprinkles"),
    GLAZED("Glazed"),
    POWDERED_SUGAR("Powdered Sugar"),
    CINNAMON_SUGAR("Cinnamon Sugar"),
    FROSTING_CHOCOLATE("Chocolate Frosting"),
    FROSTING_VANILLA("Vanilla Frosting"),
    NUTS("Nuts");

    private String label;

    RegularTopping(String label) {
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
