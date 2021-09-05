package com.company;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());

        double gamePrice = 0;
        double totalMoneySpent = 0;
        String games = scanner.nextLine();
        while (!games.equals("Game Time")) {

            if (games.equals("OutFall 4")) {
                gamePrice = 39.99;
                if (currentBalance >= gamePrice) {
                    System.out.printf("Bought %s%n", games);
                    totalMoneySpent += gamePrice;
                    currentBalance -= gamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (games.equals("CS: OG")) {
                gamePrice = 15.99;
                if (currentBalance >= gamePrice) {
                    System.out.printf("Bought %s%n", games);
                    totalMoneySpent += gamePrice;
                    currentBalance -= gamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (games.equals("Zplinter Zell")) {
                gamePrice = 19.99;
                if (currentBalance >= gamePrice) {
                    System.out.printf("Bought %s%n", games);
                    totalMoneySpent += gamePrice;
                    currentBalance -= gamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (games.equals("Honored 2")) {
                gamePrice = 59.99;
                if (currentBalance >= gamePrice) {
                    System.out.printf("Bought %s%n", games);
                    totalMoneySpent += gamePrice;
                    currentBalance -= gamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (games.equals("RoverWatch")) {
                gamePrice = 29.99;
                if (currentBalance >= gamePrice) {
                    System.out.printf("Bought %s%n", games);
                    totalMoneySpent += gamePrice;
                    currentBalance -= gamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (games.equals("RoverWatch Origins Edition")) {
                gamePrice = 39.99;
                if (currentBalance >= gamePrice) {
                    System.out.printf("Bought %s%n", games);
                    totalMoneySpent += gamePrice;
                    currentBalance -= gamePrice;
                } else {
                    System.out.println("Too Expensive");
                }
            } else {
                System.out.println("Not Found");
            }
            games = scanner.nextLine();
        }
        if (currentBalance <= 0) {
            System.out.println("Out of money!");
        } else {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalMoneySpent, currentBalance );

        }
    }
}
