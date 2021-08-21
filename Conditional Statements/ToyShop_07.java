package com.company;

import java.util.Scanner;

public class ToyShop_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceExcursion = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddies = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        int totalCount = puzzles + dolls + teddies + minions + trucks;

        double totalProfit = puzzles * 2.60 + dolls * 3 + teddies * 4.10
                + minions * 8.20 + trucks * 2;

        if (totalCount >= 50) {
            totalProfit *= 0.75;
        }

        totalProfit *= 0.9;

        if (priceExcursion <= totalProfit) {
            System.out.printf("Yes! %.2f lv left.", totalProfit - priceExcursion);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.",
                    priceExcursion - totalProfit);
        }
    }
}