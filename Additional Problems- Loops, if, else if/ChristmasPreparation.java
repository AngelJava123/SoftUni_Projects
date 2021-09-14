package com.company;

import java.util.Scanner;

public class ChristmasPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rolls = Integer.parseInt(scanner.nextLine());
        int fabricRolls = Integer.parseInt(scanner.nextLine());
        double glueLiters = Double.parseDouble(scanner.nextLine());
        double percentDiscount = Double.parseDouble(scanner.nextLine());

        double rollsPrice = rolls * 5.80;
        double fabricRollsPrice = fabricRolls * 7.20;
        double glueLitersPrice = glueLiters * 1.20;
        double allPrice = rollsPrice + fabricRollsPrice + glueLitersPrice;
        double percent = percentDiscount * 0.01;
        double discountPrice = allPrice - (allPrice * percent);

        System.out.printf("%.3f", discountPrice);
    }
}
