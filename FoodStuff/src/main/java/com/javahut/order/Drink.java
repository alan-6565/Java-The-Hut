package com.javahut.order;

import com.javahut.menu.DrinkCategory;
import com.javahut.menu.DrinkSize;
import com.javahut.menu.DrinkType;

public class Drink implements LineItem{
    private DrinkType type;
    private DrinkSize size;

    public Drink(DrinkType type, DrinkSize size) {
        this.type = type;
        this.size = size;
    }

    @Override
    public double price() {
        double base;
        switch (type.category()) {
            case COFFEE -> base = 2.0;
            case SMOOTHIE -> base = 3.0;
            default -> base = 1.0;
        }

        return switch (size) {
            case SMALL -> base;
            case MEDIUM -> base + 0.50;
            case LARGE -> base + 1.00;
        };
    }

    @Override
    public String describe() {
        String format = String.format("%.2f", price());

        return size + " " + type + " - $" + format;
    }
}
