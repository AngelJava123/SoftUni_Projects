package com.company;

import java.util.Scanner;

public class ExcursionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();

        double excursionPrice = 0;

        if (peopleCount <= 5) {
            if (season.equals("spring")) {
                excursionPrice = peopleCount * 50.00;
            } else if (season.equals("summer")) {
                excursionPrice = peopleCount * (48.50 - (48.50 * 0.15));
            } else if (season.equals("autumn")) {
                excursionPrice = peopleCount * 60.00;
            } else if (season.equals("winter")) {
                excursionPrice = peopleCount * (86.00 + (86.00 * 0.08));
            }
        } else {
            if (season.equals("spring")) {
                excursionPrice = peopleCount * 48.00;
            } else if (season.equals("summer")) {
                excursionPrice = peopleCount * (45.00 - (45.00 * 0.15));
            } else if (season.equals("autumn")) {
                excursionPrice = peopleCount * 49.50;
            } else if (season.equals("winter")) {
                excursionPrice = peopleCount * (85.00 + (85.00 * 0.08));
            }
        }
        System.out.printf("%.2f leva.", excursionPrice);
    }
}
