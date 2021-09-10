package com.company;

import java.util.Scanner;

public class Pets_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysCount = Integer.parseInt(scanner.nextLine()); // брой дни
        int foodLeft = Integer.parseInt(scanner.nextLine()); // оставена храна в килограми
        double dogFood = Double.parseDouble(scanner.nextLine()); // храна на ден за кучето в килограми
        double catFood = Double.parseDouble(scanner.nextLine()); // храна на ден за котката в килограми
        double turtleFood = Double.parseDouble(scanner.nextLine()); // храна на ден за костенурката в грамове

        double dog = daysCount * dogFood;
        double cat = daysCount * catFood;
        double turtle = daysCount * turtleFood / 1000;

        double totalFood = dog + cat + turtle;

        if (totalFood <= foodLeft) {
            System.out.printf("%.0f kilos of food left.", Math.floor(foodLeft - totalFood));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(totalFood - foodLeft));
        }
    }
}
