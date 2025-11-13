package com.javahut;

import com.javahut.menu.*;
import com.javahut.order.Donut;
import com.javahut.order.Drink;

public class Main {
    public static void main(String[] args) {
        Donut d = new Donut(DonutSize.CLASSIC, DonutType.YEAST, SpecialOption.FILLING_CREAM);
        d.addRegularToppings(RegularTopping.SPRINKLES);
        d.addPremiumToppings(PremiumTopping.WHIPPED_CREAM);
        System.out.println(d.describe());

        Drink d1 = new Drink(DrinkType.MOCHA, DrinkSize.SMALL);
        System.out.println(d1.describe());
    }
}
