package com.company;

import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pound = Double.parseDouble(scanner.nextLine());

        double USDollars = pound * 1.31;
        System.out.printf("%.3f", USDollars);
    }
}
