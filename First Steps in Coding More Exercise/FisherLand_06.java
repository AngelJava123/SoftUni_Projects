package com.company;

import java.util.Scanner;

public class FisherLand_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double bonitoPricePerKilo = Double.parseDouble(scanner.nextLine());
        double horseMackerelPricePerKilo = Double.parseDouble(scanner.nextLine());
        double bonitoPerKilo = Double.parseDouble(scanner.nextLine());
        double horseMackerelPerKilo = Double.parseDouble(scanner.nextLine());
        double musselsPerKilo = Double.parseDouble(scanner.nextLine());

        bonitoPricePerKilo = bonitoPricePerKilo + (bonitoPricePerKilo * 0.60);
        double sumBonito = bonitoPerKilo * bonitoPricePerKilo;

        horseMackerelPricePerKilo = horseMackerelPricePerKilo + (horseMackerelPricePerKilo * 0.80);
        double sumHorseMackerel = horseMackerelPerKilo * horseMackerelPricePerKilo;

        double sumMussels = musselsPerKilo * 7.50;

        double totalSum = sumBonito + sumHorseMackerel + sumMussels;

        System.out.printf("%.2f", totalSum);


    }
}
