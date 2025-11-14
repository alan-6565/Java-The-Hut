package com.javahut.ui;

import com.javahut.menu.*;
import com.javahut.order.Donut;
import com.javahut.order.Drink;
import com.javahut.order.Order;
import com.javahut.order.Side;

import java.util.Scanner;

public class OrderScreen {
// this code would be the order screen where ll my orders will go through
    public void run(Scanner sc, Order order){
        boolean running = true;

        while (running) {
            System.out.println("==============");
            System.out.println("1) Add Donut");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Side");
            System.out.println("4) Checkout");
            System.out.println("0) Exit");
            System.out.println("==============");
            System.out.println(">");

            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    System.out.println("Choose a Donut size:");
                    DonutSize size = promptEnum(sc, DonutSize.class);

                    System.out.println("Choose a Donut Type:");
                    DonutType type = promptEnum(sc, DonutType.class);

                    System.out.println("Would You like Filling");
                    SpecialOption special = promptEnum(sc, SpecialOption.class);

                    Donut d = new Donut(size, type, special);

                    System.out.println("Choose your toppings use (space with commas): [Sprinkles, Glazed, Powdered Sugar, Cinnamon Sugar, Chocolate Frosting, Vanilla Frosting");
                    String answer = sc.nextLine().trim().toLowerCase();

                    String[] tokens = answer.split(",");
                    for (String token1 : tokens) {
                        String t = token1.trim();
                        if (t.isEmpty()) continue;

                        if (t.contains("sprinkle")) d.addRegularToppings(RegularTopping.SPRINKLES);
                        else if (t.contains("glaz")) d.addRegularToppings(RegularTopping.GLAZED);
                        else if (t.contains("powder")) d.addRegularToppings(RegularTopping.POWDERED_SUGAR);
                        else if (t.contains("cinnamon")) d.addRegularToppings(RegularTopping.CINNAMON_SUGAR);
                        else if (t.contains("choco") && t.contains("frost")) d.addRegularToppings(RegularTopping.FROSTING_CHOCOLATE);
                        else if (t.contains("vanilla") && t.contains("frost")) d.addRegularToppings(RegularTopping.FROSTING_VANILLA);


                    }

                    System.out.println("Choose some special toppings (use space with commas): [Fresh Fruits, Cookie Crumble, Whipped Cream, Ice Cream Scoop]");
                    String answer2 = sc.nextLine().trim().toLowerCase();

                    String[] tokens1 = answer.split(",");
                    for (String token2 : tokens1) {
                        String t = token2.trim();
                        if (t.isEmpty()) continue;

                        if (t.contains("fruit")) d.addPremiumToppings(com.javahut.menu.PremiumTopping.FRESH_FRUITS);
                        else if (t.contains("cookie")) d.addPremiumToppings(com.javahut.menu.PremiumTopping.COOKIE_CRUMBLE);
                        else if (t.contains("whip")) d.addPremiumToppings(com.javahut.menu.PremiumTopping.WHIPPED_CREAM);
                        else if (t.contains("ice")) d.addPremiumToppings(com.javahut.menu.PremiumTopping.ICE_CREAM_SCOOP);


                    }

                    order.add(d);
                    System.out.println("Donut added. Items: " + order.items().size()
                            + " | Total: $" + String.format("%.2f", order.total()));
                    break;
                case 2:
                    Drink drink = new Drink(DrinkType.LATTE, DrinkSize.SMALL);
                    order.add(drink);
                    System.out.println("Drink added. Items: " + order.items().size() + " | Total: $" + String.format("%.2f", order.total()));
                    break;
                case 3:
                    Side side = new Side("Fruit Cup", 1.50);
                    order.add(side);
                    System.out.println("Side added, Items: " + order.items().size() + " | Total: $" + String.format("%.2f", order.total()));
                    break;
                case 4:
                    System.out.println();
                    System.out.println(order.renderReciept());
                    order.saveReciept();
                    running = false;
                    break;
                case 0:
                    System.out.println("Order canceled.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Option.");
            }
        }
    }

    private <E extends Enum<E>> E promptEnum(Scanner sc, Class<E> enumClass) {
        E[] values = enumClass.getEnumConstants();
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ") " + values[i]);
        }
        System.out.println("> ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice < 1 || choice > values.length) {
            System.out.println("Invalid choice, defaulting to first option.");
            return values[0];
        }
        return values[choice - 1];
    }
}
