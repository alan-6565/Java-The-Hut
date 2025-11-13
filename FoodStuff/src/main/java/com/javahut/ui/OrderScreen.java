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
                    Donut d = new Donut(DonutSize.CLASSIC, DonutType.YEAST, SpecialOption.NONE);
                    d.addRegularToppings(RegularTopping.SPRINKLES);
                    order.add(d);
                    System.out.println("Donut added. Items: " + order.items().size() + " | TOTAL: $" + String.format("%.2f", order.total()));
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
}
