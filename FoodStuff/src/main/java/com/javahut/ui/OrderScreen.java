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
            System.out.println("╔═══════════════════════════════════════════════════════╗");
            System.out.println("║             ☕  JAVA THE HUT — ORDER PAD  🍩           ║");
            System.out.println("║               your donuts, drinks & sides             ║");
            System.out.println("╠═══════════════════════════════════════════════════════╣");
            System.out.printf ("║  Items in cart: %-3d   Current total: $%7.2f         ║%n",
                    order.items().size(), order.total());
            System.out.println("╚═══════════════════════════════════════════════════════╝");
            System.out.println();
            System.out.println("   1) Add Donut");
            System.out.println("   2) Add Drink");
            System.out.println("   3) Add Side");
            System.out.println("   4) Checkout");
            System.out.println("   0) Cancel Order");
            System.out.println();
            System.out.print ("   Choose an option ➤ ");

            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    System.out.println("Enter donut size (1 Donut, Half a Dozen, Dozen):");
                    String sizeInput = sc.nextLine().trim().toLowerCase();
                    DonutSize size;
                    if (sizeInput.contains("1")) size = DonutSize.MINI_BITE;
                    else if (sizeInput.contains("half")) size = DonutSize.CLASSIC;
                    else if (sizeInput.contains("dozen")) size = DonutSize.JUMBO;
                    else {
                        System.out.println("Unknown size, defaulting to Classic.");
                        size = DonutSize.CLASSIC;
                    }

                    System.out.println("Enter donut type (yeast, cake, mochi):");
                    String typeInput = sc.nextLine().trim().toLowerCase();
                    DonutType type;
                    if (typeInput.contains("yeast")) type = DonutType.YEAST;
                    else if (typeInput.contains("cake")) type = DonutType.CAKE;
                    else if (typeInput.contains("mochi")) type = DonutType.MOCHI;
                    else {
                        System.out.println("Unknown type, defaulting to Yeast.");
                        type = DonutType.YEAST;
                    }

                    System.out.println("Choose filling (cream, jelly, none):");
                    String fillInput = sc.nextLine().trim().toLowerCase();
                    SpecialOption special;
                    if (fillInput.contains("cream")) special = SpecialOption.FILLING_CREAM;
                    else if (fillInput.contains("jelly")) special = SpecialOption.FILLING_JELLY;
                    else if (fillInput.contains("none")) special = SpecialOption.NONE;
                    else {
                        System.out.println("Unknown filling, defaulting to NONE.");
                        special = SpecialOption.NONE;
                    }
                    Donut d = new Donut(size, type, special);

                    System.out.println("Choose frosting (chocolate, vanilla, pink, none):");
                    String frostInput = sc.nextLine().trim().toLowerCase();
                    Frosting frosting;
                    if (frostInput.contains("choco")) frosting = Frosting.CHOCOLATE;
                    else if (frostInput.contains("vanilla")) frosting = Frosting.VANILLA;
                    else if (frostInput.contains("pink") || frostInput.contains("straw")) frosting = Frosting.PINK;
                    else if (frostInput.contains("none")) frosting = Frosting.NONE;
                    else {
                        System.out.println("Unknown frosting, defaulting to NONE.");
                        frosting = Frosting.NONE;
                    }


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
                        else if (t.contains("vanilla") && t.contains("frost")) d.addRegularToppings(RegularTopping.FROSTING_VANILLA);// this code allows me to type in the specific item id like


                    }

                    System.out.println("Choose some special toppings (use space with commas): [Fresh Fruits, Cookie Crumble, Whipped Cream, Ice Cream Scoop]");
                    String answer2 = sc.nextLine().trim().toLowerCase();

                    String[] tokens1 = answer2.split(",");
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
                    System.out.println("Enter drink name (e.g., latte, espresso, cappuccino, mocha, smoothie, water):");
                    String drinkInput = sc.nextLine().trim().toLowerCase();

                    DrinkType type1;
                    DrinkSize size1;

                    if (drinkInput.contains("latte")) type1 = DrinkType.LATTE;
                    else if (drinkInput.contains("espresso")) type1 = DrinkType.ESPRESSO;
                    else if (drinkInput.contains("macchiato")) type1 = DrinkType.MACCHIATO;
                    else if (drinkInput.contains("cappuccino")) type1 = DrinkType.CAPPUCCINO;
                    else if (drinkInput.contains("mocha")) type1 = DrinkType.MOCHA;
                    else if (drinkInput.contains("smoothie") && drinkInput.contains("straw")) type1 = DrinkType.STRAWBERRY_SMOOTHIE;
                    else if (drinkInput.contains("smoothie") && drinkInput.contains("banana")) type1 = DrinkType.BANANA_SMOOTHIE;
                    else if (drinkInput.contains("smoothie") && drinkInput.contains("mix")) type1 = DrinkType.MIX_SMOOTHIE;
                    else type1 = DrinkType.WATER; // default

                    System.out.println("Enter size (small, medium, large: ");
                    sizeInput = sc.nextLine().trim().toLowerCase();

                    if (sizeInput.startsWith("s")) size1 = DrinkSize.SMALL;
                    else if (sizeInput.startsWith("m")) size1 = DrinkSize.MEDIUM;
                    else if (sizeInput.startsWith("l")) size1 = DrinkSize.LARGE;
                    else {
                        System.out.println("Unknown size, defaulting to medium.");
                        size1 = DrinkSize.MEDIUM;
                    }

                    Drink drink = new Drink(type1, size1);
                    order.add(drink);
                    System.out.println("Added " + size1 + " " + type1 + " | Total: $" + String.format("%.2f", order.total()));
                    break;
                case 3:
                    System.out.println("Enter side name (e.g., fruit cup, chips, donut holes):");
                    String sideInput = sc.nextLine().trim().toLowerCase();

                    String name = "";
                    double price = 0.00;

                    if (sideInput.contains("fruit")){
                        name = "Fruit Cup";
                        price = 3.50;
                    } else if (sideInput.contains("chips")) {
                        name = "Chips";
                        price = 2.25;
                    } else if (sideInput.contains("donut")) {
                        name = "Donut Holes";
                        price = 4.00;// here i manually typed in lots of the prices since there are very few
                    }

                    Side side = new Side(name, price);
                    order.add(side);
                    System.out.println("Added " + name + " | Total: $" + String.format("%.2f", order.total()));
                    break;
                case 4:
                    if (!order.isValidPerRule()) {
                        System.out.println("If you have 0 donuts, you must purchase a drink or a side.");
                        break; // return to menu
                    }

                    System.out.println();
                    printReceiptBanner(order);             //here im calling in the big reciept prompt i have in the bottom of the code
                    System.out.println(order.renderReciept());
                    order.saveReciept();
                    System.out.println();
                    System.out.println("Receipt saved Enjoy");
                    System.out.println();

                    System.out.println("   (Press Enter to return to Home Screen)");
                    sc.nextLine();
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
            System.out.println("Invalid choice, defaulting to first option.");// this is the prompts i call into each case
            return values[0];
        }
        return values[choice - 1];
    }

    private void printReceiptBanner(Order order) {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║                  🧾  ORDER SUMMARY  🧾                ║");
        System.out.println("║            Thank you for visiting Java the Hut        ║");
        System.out.println("╠═══════════════════════════════════════════════════════╣");
        System.out.printf ("║  Final items: %-3d   Total due: $%7.2f              ║%n",
                order.items().size(), order.total());
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        System.out.println();
    }
}
