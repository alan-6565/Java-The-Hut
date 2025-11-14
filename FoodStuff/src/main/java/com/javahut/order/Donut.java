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
        double base = PricingTable.donutBase(size);
        double spec = PricingTable.donutSpecial(special);
        double perTopping = PricingTable.toppingPrice(size);
        double toppingsCost = (regularToppings.size() + premiumToppings.size()) * perTopping;
        return base + spec + toppingsCost;
    }

    @Override
    public String describe() {
        String regTops = regularToppings.isEmpty() ? "no regular toppings" : regularToppings.toString();
        String premTops = premiumToppings.isEmpty() ? "no premium toppings" : premiumToppings.toString();// these are if else statement shorter version of the ones under
//        String regTops;
//        if (regularToppings.isEmpty()) {
//            regTops = "no regular toppings";
//        } else {
//            regTops = regularToppings.toString();
//        }
        return size + " " + type + " Donut with " + regTops + " and " + premTops + " (" + special + ")";
    }
}
