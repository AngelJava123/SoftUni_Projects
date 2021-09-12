package com.company;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String order = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        printFinalPrice(quantity, order);

    }

    private static void printFinalPrice(double quantity, String order) {
        switch (order) {
            case "coffee":
                quantity *= 1.50;
                break;
            case "water":
                quantity *= 1.00;
                break;
            case "coke":
                quantity *= 1.40;
                break;
            case "snacks":
                quantity *= 2.00;
                break;
        }
        System.out.printf("%.2f",quantity);
    }
}
