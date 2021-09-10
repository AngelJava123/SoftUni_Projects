package com.company;

import java.util.Scanner;

public class TransportPrice_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // брой километри
        String timeOfDay = scanner.nextLine();

        if (n < 20 && timeOfDay.equals("day")) {
            System.out.printf("%.2f", 0.70 + n * 0.79 );
        } else if (n < 20 && timeOfDay.equals("night")) {
            System.out.printf("%.2f", 0.70 + n * 0.90);
        } else if (n >= 20 && n < 100 && timeOfDay.equals("day")) {
            System.out.printf("%.2f", n * 0.09);
        } else if (n >= 20 && n < 100 && timeOfDay.equals("night")) {
            System.out.printf("%.2f", n * 0.09);
        } else if (n >= 100 && timeOfDay.equals("day")) {
            System.out.printf("%.2f", n * 0.06);
        } else if (n >= 100 && timeOfDay.equals("night")) {
            System.out.printf("%.2f", n * 0.06);
        }
    }
}

