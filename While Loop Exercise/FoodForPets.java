package com.company;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double totalFood = Double.parseDouble(scanner.nextLine());

        double totalEatenFood = 0;
        double totalCatEaten = 0;
        double totalDogEaten = 0;

        for (int i = 1; i <=days ; i++) {
            int dogEaten = Integer.parseInt(scanner.nextLine());
            int catEaten = Integer.parseInt(scanner.nextLine());

            totalCatEaten += catEaten;
            totalDogEaten += dogEaten;

            if (i % 3 == 0) {
                double currentBiscuits = (dogEaten + catEaten) * 0.1;
                totalEatenFood += currentBiscuits;
            }
        }
        double allEatenFood = totalCatEaten + totalDogEaten;
        double percentFood = (allEatenFood / totalFood) * 100;
        double percentDog = (totalDogEaten / allEatenFood) * 100;
        double percentCat = (totalCatEaten / allEatenFood) * 100;

        System.out.printf("Total eaten biscuits: %dgr.%n", Math.round(totalEatenFood));
        System.out.printf("%.2f%% of the food has been eaten.%n", percentFood);
        System.out.printf("%.2f%% eaten from the dog.%n", percentDog);
        System.out.printf("%.2f%% eaten from the cat.", percentCat);

    }
}
