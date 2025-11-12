package com.javahut.ui;

import java.util.Scanner;

public class OrderScreen {

    public void run(Scanner sc){
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
                    System.out.println("Donut Added");
                    break;
                case 2:
                    System.out.println("Drink Added");
                    break;
                case 3:
                    System.out.println("Side Added");
                    break;
                case 4:
                    System.out.println("Checkout Added");
                    break;
                case 0:
                    System.out.println("byebye");
                    break;
                default:
                    break;
            }
        }
    }
}
