package com.company;

import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfBalls = Integer.parseInt(scanner.nextLine());

        int totalPoints = 0;
        int red = 0;
        int orange = 0;
        int yellow = 0;
        int white = 0;
        int otherColorsPicked = 0;
        int dividesFromBlackBalls = 0;

        for (int i = 1; i <= numberOfBalls ; i++) {
            String balls = scanner.nextLine();

            if (balls.equals("red")) {
                totalPoints += 5;
                red++;
            } else if (balls.equals("orange")) {
                totalPoints += 10;
                orange++;
            } else if (balls.equals("yellow")) {
                totalPoints += 15;
                yellow++;
            } else if (balls.equals("white")) {
                totalPoints += 20;
                white++;
            } else if (balls.equals("black")) {
                totalPoints /= 2;
                dividesFromBlackBalls++;
            } else {
                otherColorsPicked++;
            }
        }
        System.out.printf("Total points: %d%n", totalPoints);
        System.out.printf("Points from red balls: %d%n", red);
        System.out.printf("Points from orange balls: %d%n", orange);
        System.out.printf("Points from yellow balls: %d%n", yellow);
        System.out.printf("Points from white balls: %d%n", white);
        System.out.printf("Other colors picked: %d%n", otherColorsPicked);
        System.out.printf("Divides from black balls: %d", dividesFromBlackBalls);
    }
}
