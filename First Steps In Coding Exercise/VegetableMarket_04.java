package com.company;

import java.util.Scanner;

public class VegetableMarket_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vegetablePerKilo = Double.parseDouble(scanner.nextLine());
        double fruitPerKilo = Double.parseDouble(scanner.nextLine());
        int totalVegetableKilos = Integer.parseInt(scanner.nextLine());
        int totalFruitKilos = Integer.parseInt(scanner.nextLine());

        double totalVegSum = vegetablePerKilo * totalVegetableKilos;
        double totalFruitSum = fruitPerKilo * totalFruitKilos;

        double totalPrice = totalFruitSum + totalVegSum;

        System.out.printf("%.2f", totalPrice / 1.94);
    }
}
