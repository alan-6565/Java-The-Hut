package com.javahut.order;

import com.javahut.menu.DonutSize;
import com.javahut.menu.DrinkSize;
import com.javahut.menu.DrinkType;
import com.javahut.menu.SpecialOption;

public final class PricingTable {
    private PricingTable(){}

    //Donut pricing
    public static double donutBase(DonutSize size) {
        return switch (size) {
            case MINI_BITE -> 1.25;
            case CLASSIC -> 2.25;
            case JUMBO -> 3.35;
        };
    }

    public static double donutSpecial(SpecialOption special) {
        return switch (special) {
            case NONE -> 0.0;
            case FILLING_CREAM, FILLING_JELLY -> 0.35;
        };
    }

    public static double drinkBase(DrinkType type) {
        return switch (type.category()) {
            case COFFEE -> 2.00;
            case SMOOTHIE -> 3.00;
            case WATER -> 1.00;
        };
    }

    public static double drinkSize(DrinkSize size) {
        return switch (size) {
            case SMALL -> 0.00;
            case MEDIUM -> 0.50;
            case LARGE -> 1.00;
        };
    }


    public static double toppingPrice(DonutSize size) {
        return switch (size) {
            case MINI_BITE -> 0.50;
            case CLASSIC   -> 1.00;
            case JUMBO     -> 1.50;
        };
    }
}
