package com.company;

import java.util.Scanner;

public class DeerOfSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int santaMissingDays = Integer.parseInt(scanner.nextLine());
        int leftFoodInKilos = Integer.parseInt(scanner.nextLine());
        double foodFirstAnimal = Double.parseDouble(scanner.nextLine());
        double foodSecondAnimal = Double.parseDouble(scanner.nextLine());
        double foodThirdAnimal = Double.parseDouble(scanner.nextLine());

        double first = santaMissingDays * foodFirstAnimal;
        double second = santaMissingDays * foodSecondAnimal;
        double third = santaMissingDays * foodThirdAnimal;
        double allSum = first + second + third;

        if (allSum <= leftFoodInKilos) {
            double left = leftFoodInKilos - allSum;
            System.out.printf("%.0f kilos of food left.", Math.floor(left) );
        } else {
            double lefF = allSum - leftFoodInKilos;
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(lefF));
        }

    }
}
