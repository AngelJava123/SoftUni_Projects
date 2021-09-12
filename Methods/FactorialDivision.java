package com.company;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double first = Integer.parseInt(scanner.nextLine());
        double second = Integer.parseInt(scanner.nextLine());
        double result = factorial(first) / factorial(second);

        System.out.printf("%.2f", result);
    }

    private static double factorial(double n) {

        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }
}
