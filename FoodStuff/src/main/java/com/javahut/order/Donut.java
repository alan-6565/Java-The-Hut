package com.javahut.order;

import com.javahut.menu.*;

import java.util.ArrayList;
import java.util.List;
// this is where all donuts are created
public class Donut implements LineItem{
    private DonutSize size;
    private DonutType type;
    private SpecialOption special;
    private List<RegularTopping> regularToppings = new ArrayList<>();
    private List<PremiumTopping> premiumToppings = new ArrayList<>();// these arraylists connect to the enums and get stored there

    public Donut(DonutSize size, DonutType type, SpecialOption special) {
        this.size = size;
        this.type = type;
        this.special = special;
    }

    public void addRegularToppings(RegularTopping topping){
        regularToppings.add(topping);
    }

    public void addPremiumToppings(PremiumTopping topping){
        premiumToppings.add(topping);
    }

    @Override// these overrides connect to Line Item
    public double price() {
        return 2.0 + regularToppings.size() * 0.4 + premiumToppings.size() * 0.75;
    }

    @Override
    public String describe() {
        String format = String.format("%.2f", price());
        String regTops = regularToppings.isEmpty() ? "no regular toppings" : regularToppings.toString();
        String premTops = premiumToppings.isEmpty() ? "no premium toppings" : premiumToppings.toString();// these are if else statement shorter version of the ones under
//        String regTops;
//        if (regularToppings.isEmpty()) {
//            regTops = "no regular toppings";
//        } else {
//            regTops = regularToppings.toString();
//        }
        return size + " " + type + " Donut with " + regTops + " and " + premTops + " (" + special + ") - $" + format;
    }
}
