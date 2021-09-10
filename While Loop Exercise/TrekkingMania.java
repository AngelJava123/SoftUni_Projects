package com.company;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int climberNumber = Integer.parseInt(scanner.nextLine());

        double musalla = 0;
        double monbland = 0;
        double kilimandjaro = 0;
        double k2 = 0;
        double everest = 0;
        double total = 0;

        for (int i = 0; i < climberNumber ; i++) {
            int peopleInGroups = Integer.parseInt(scanner.nextLine());

            if (peopleInGroups <= 5) {
                musalla += peopleInGroups;
            } else if (peopleInGroups >= 6 && peopleInGroups <= 12) {
                monbland += peopleInGroups;
            } else if (peopleInGroups >= 13 && peopleInGroups <= 25) {
                kilimandjaro += peopleInGroups;
            } else if (peopleInGroups >= 26 && peopleInGroups <= 40) {
                k2 += peopleInGroups;
            } else if (peopleInGroups >= 41) {
                everest += peopleInGroups;
            }
            total += peopleInGroups;
        }
        double musalaPercent = (musalla / total) * 100;
        double monblandPercent = (monbland / total) * 100;
        double kilimandjaroPercent = (kilimandjaro / total) * 100;
        double k2Percent = (k2 / total) * 100;
        double everestPercent = (everest / total) * 100;

        System.out.printf("%.2f%%%n", musalaPercent);
        System.out.printf("%.2f%%%n", monblandPercent);
        System.out.printf("%.2f%%%n", kilimandjaroPercent);
        System.out.printf("%.2f%%%n", k2Percent);
        System.out.printf("%.2f%%%n", everestPercent);

    }
}
