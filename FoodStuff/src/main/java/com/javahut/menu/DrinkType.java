package com.javahut.menu;

public enum DrinkType {
    LATTE("Latte", DrinkCategory.COFFEE),
    ESPRESSO("Espresso", DrinkCategory.COFFEE),
    MACCHIATO("Macchiato", DrinkCategory.COFFEE),
    CAPPUCCINO("Cappuccino", DrinkCategory.COFFEE),
    MOCHA("Mocha", DrinkCategory.COFFEE),
    STRAWBERRY_SMOOTHIE("Strawberry Smoothie", DrinkCategory.SMOOTHIE),
    BANANA_SMOOTHIE("Banana Smoothie", DrinkCategory.SMOOTHIE),
    MIX_SMOOTHIE("Mix Smoothie", DrinkCategory.SMOOTHIE),
    WATER("Water", DrinkCategory.WATER);

    private final String label;
    private final DrinkCategory category;

    DrinkType(String label, DrinkCategory category) {
        this.label = label;
        this.category = category;
    }

    public String label(){
        return label;
    }

    public DrinkCategory category(){
        return category;
    }

    @Override
    public String toString() {
        return label;
    }
}
