package com.company;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int totalLitters = 0;

        for (int litters = 1; litters <= n ; litters++) {
            int quantities = Integer.parseInt(scanner.nextLine());
            totalLitters += quantities;

            if (totalLitters > capacity) {
                System.out.println("Insufficient capacity!");
                totalLitters -= quantities;
            }
        }
        System.out.println(totalLitters);
    }
}
