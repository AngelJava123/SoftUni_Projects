package com.company;

import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int filmNumber = Integer.parseInt(scanner.nextLine());

        double highRating = 0;
        double minRating = 11;
        double average = 0;
        String nameHighRating = "";
        String nameMinRating = "";

        for (int i = 1; i <= filmNumber ; i++) {
            String filmName = scanner.nextLine();
            double filmRating = Double.parseDouble(scanner.nextLine());

            if (filmRating > highRating) {
                highRating = filmRating;
                nameHighRating = filmName;
            }

            if (filmRating < minRating) {
                minRating = filmRating;
                nameMinRating = filmName;
            }
            average += filmRating;
        }
        Double averageSum = average / filmNumber;
        System.out.printf("%s is with highest rating: %.1f%n", nameHighRating, highRating);
        System.out.printf("%s is with lowest rating: %.1f%n", nameMinRating, minRating);
        System.out.printf("Average rating: %.1f", averageSum);
    }
}
