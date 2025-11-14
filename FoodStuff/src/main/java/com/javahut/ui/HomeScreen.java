package com.javahut.ui;

import com.javahut.order.Order;

import java.util.Scanner;
// this code is the home screen
public class HomeScreen {
    Scanner sc = new Scanner(System.in);
    public void run(){
        boolean running = true;

        while (running) {
            try {
                String loading = "Loading into Java the Hut";
                for (char c : loading.toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(50);
                }
                System.out.println("... ☕ Done!");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();// creates a loading screen
            }
            System.out.println("╔═══════════════════════════════════════════════════════╗");
            System.out.println("║                 ☕  JAVA THE HUT  🍩                   ║");
            System.out.println("║        Where Coffee Meets Code — and Donuts Win.      ║");
            System.out.println("╚═══════════════════════════════════════════════════════╝");
            System.out.println("              [ Welcome to the Order System ]            ");
            System.out.println();
            System.out.println("               1) Start a New Order");
            System.out.println("               0) Exit the Program");
            System.out.println();
            System.out.print("                Select an option ➤ ");
            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    Order order = new Order(); // creates a fresh new cart
                    new OrderScreen().run(sc, order); // im running the new cart into the orderscreen
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Not valid option");
            }
        }
        System.out.println("Please come again");

    }
}
