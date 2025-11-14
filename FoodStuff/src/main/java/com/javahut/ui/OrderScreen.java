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

                    System.out.println("Choose your toppings use (space with commas): [");

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
