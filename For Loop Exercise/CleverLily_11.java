package com.company;

import java.util.Scanner;

public class CleverLily_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washer = Double.parseDouble(scanner.nextLine());
        int priceToy = Integer.parseInt(scanner.nextLine());

        int toys = 0;
        double allMoney = 0.0;
        double saveMoney = 0.0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                allMoney += 10;
                saveMoney = saveMoney + allMoney - 1;
            } else {
                toys++;
            }
        }
        double totalSum = toys * priceToy + saveMoney;
        if (totalSum >= washer) {
            System.out.printf("Yes! %.2f", totalSum - washer);
        } else {
            System.out.printf("No! %.2f", washer - totalSum);
        }
    }
}
