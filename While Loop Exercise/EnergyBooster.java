package com.company;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String setSize = scanner.nextLine();
        int setNumber = Integer.parseInt(scanner.nextLine());

        double price = 0;

        if (fruit.equals("Watermelon")) {
            if (setSize.equals("small")) {
                price = (2 * 56) * setNumber;
            } else if (setSize.equals("big")) {
                price = (5 * 28.70) * setNumber;
            }
        } else if (fruit.equals("Mango")) {
            if (setSize.equals("small")) {
                price = (2 * 36.66) * setNumber;
            } else if (setSize.equals("big")) {
                price = (5 * 19.60) * setNumber;
            }
        } else if (fruit.equals("Pineapple")) {
            if (setSize.equals("small")) {
                price = (2 * 42.10) * setNumber;
            } else if (setSize.equals("big")) {
                price = (5 * 24.80) * setNumber;
            }
        } else if (fruit.equals("Raspberry")) {
            if (setSize.equals("small")) {
                price = (2 * 20) * setNumber;
            } else if (setSize.equals("big")) {
                price = (5 * 15.20) * setNumber;
            }
        }
        if (price >= 400 && price <= 1000) {
            price = price - (price * 0.15);
        } else if (price > 1000) {
            price = price - (price * 0.50);
        }
        System.out.printf("%.2f lv.", price);
    }
}