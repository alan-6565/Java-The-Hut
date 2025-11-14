package com.javahut.order;
import com.javahut.menu.*;
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
        double base = PricingTable.drinkBase(type);
        return base + PricingTable.drinkSize(size);
    }

    @Override
    public String describe() {

        return size + " " + type;
    }
}
