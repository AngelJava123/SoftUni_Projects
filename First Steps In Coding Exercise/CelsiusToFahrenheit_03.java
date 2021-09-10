package com.company;

import java.util.Scanner;

public class CelsiusToFahrenheit_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double degreesC = Double.parseDouble(scanner.nextLine());

        double degreesF = degreesC * 1.8 + 32;

        System.out.printf("%.2f", degreesF);
    }
}
