package com.javahut.menu;
//these enums were created for a quicker call out when i call an order

public enum PremiumTopping {
    FRESH_FRUITS("Fresh Fruits"),
    COOKIE_CRUMBLE("Cookie Crumble"),
    WHIPPED_CREAM("Whipped Cream"),
    ICE_CREAM_SCOOP("Ice Cream Scoop");

    private final String label;

    PremiumTopping(String label) {
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
