package com.company;

import java.util.Scanner;

public class Logistics_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWeights = Integer.parseInt(scanner.nextLine()); // броя на товарите за превоз

        double micro = 0;
        double truck = 0;
        double train = 0;

        for (int i = 1; i <= numberOfWeights ; i++) {
            int tons = Integer.parseInt(scanner.nextLine()); // тонажа на товара

            if (tons <= 3) {
                micro += tons;
            }
            if (tons >= 4 && tons <= 11 ) {
                truck += tons;
            }
            if (tons >= 12) {
                train += tons;
            }
        }
        double load = micro + truck + train;
        double average = (micro * 200 + truck * 175 + train * 120) / load;

        System.out.printf("%.2f%n", average); // средната цена на тон превозен товар
        System.out.printf("%.2f%%%n", micro / load * 100);
        System.out.printf("%.2f%%%n", truck / load * 100);
        System.out.printf("%.2f%%", train / load * 100);
    }
}
