package com.javahut.ui;

import com.javahut.order.Order;

import java.util.Scanner;
// this code is the home screen
public class HomeScreen {
    Scanner sc = new Scanner(System.in);
    public void run(){
        boolean running = true;

        while (running) {
            System.out.println("==============");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("==============");
            System.out.println(">");
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
        System.out.println("bye bye");

    }
}
