package com.company;

import java.util.Scanner;

public class FishTank_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthInSc = Integer.parseInt(scanner.nextLine());
        int WideInSc = Integer.parseInt(scanner.nextLine());
        int HeightInSc = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double Volume = lengthInSc * WideInSc * HeightInSc;
        double OverallLiters = Volume * 0.001;

        double allPercent = percent * 0.01;

        double realLiters = OverallLiters *(1-allPercent);

        System.out.printf("%.2f",realLiters);
    }
}
