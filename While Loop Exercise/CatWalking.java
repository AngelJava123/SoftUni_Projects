package com.company;

import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int walkingMinutes = Integer.parseInt(scanner.nextLine());
        int walkingNumber = Integer.parseInt(scanner.nextLine());
        int caloriesTaken = Integer.parseInt(scanner.nextLine());

        int totalMinutes = walkingMinutes * walkingNumber;
        int burnedCalories = totalMinutes * 5;

        double calories = caloriesTaken - (caloriesTaken * 0.50);

        if (burnedCalories >= calories) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", burnedCalories);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", burnedCalories);
        }
    }
}
