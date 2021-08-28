package com.company;

import java.util.Scanner;

public class SuppliesOfSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pens = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        double litterOfCleaningDetergent = Double.parseDouble(scanner.nextLine());
        int discountPercent = Integer.parseInt(scanner.nextLine());

        double sum = pens * 5.80  + markers * 7.20 + litterOfCleaningDetergent * 1.20;
        double discount = sum - ((sum * discountPercent) / 100);

        System.out.printf("%.03f", discount);
    }
}
