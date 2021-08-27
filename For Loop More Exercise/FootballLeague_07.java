package com.company;

import java.util.Scanner;

public class FootballLeague_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double Capacity = Double.parseDouble(scanner.nextLine()); // 1.	Капацитетът на стадиона
        double fansNumber = Double.parseDouble(scanner.nextLine()); // 2.	Броят на всички фенове

        double sectorA = 0;
        double sectorB = 0;
        double sectorV = 0;
        double sectorG = 0;

        for (int i = 1; i <= fansNumber; i++) {
            String sectors = scanner.nextLine();

            if (sectors.equals("A")) {
                sectorA++;
            } else if (sectors.equals("B")) {
                sectorB++;
            } else if (sectors.equals("V")) {
                sectorV++;
            } else if (sectors.equals("G")) {
                sectorG++;
            }
        }
        double percentageA = (sectorA/ fansNumber) * 100;
        double percentageB = (sectorB/ fansNumber) * 100;
        double percentageV = (sectorV/ fansNumber) * 100;
        double percentageG = (sectorG/ fansNumber) * 100;

        System.out.printf("%.2f%%%n", percentageA);
        System.out.printf("%.2f%%%n", percentageB);
        System.out.printf("%.2f%%%n", percentageV);
        System.out.printf("%.2f%%%n", percentageG);
        System.out.printf("%.2f%%", (fansNumber/Capacity) * 100);
    }
}
