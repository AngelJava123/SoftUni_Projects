package com.company;

import java.util.Scanner;

public class Harvest_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = Integer.parseInt(scanner.nextLine()); // кв.м е лозето
        double y = Double.parseDouble(scanner.nextLine()); // грозде за един кв.м
        int z = Integer.parseInt(scanner.nextLine()); // нужни литри вино
        int workers = Integer.parseInt(scanner.nextLine()); // брой работници

        double totalGrape = x * y;
        double wine = 0.4 * totalGrape / 2.5;

        if (wine >= z) {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(wine));
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(wine - z) , Math.ceil((wine - z) / workers) );
        } else {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(z - wine));
        }
    }
}
