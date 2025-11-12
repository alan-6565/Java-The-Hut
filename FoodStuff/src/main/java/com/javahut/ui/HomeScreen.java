package com.javahut.ui;

import java.util.Scanner;

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
                    new OrderScreen().run(sc);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    break;
            }
        }

    }
}
