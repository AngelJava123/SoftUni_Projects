package com.company;

import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoins = 1168 * Integer.parseInt(scanner.nextLine());
        double chinaCoins = 0.15 * Double.parseDouble(scanner.nextLine());
        double commission = 0.01 * Double.parseDouble(scanner.nextLine());

        double china = chinaCoins * 1.76;
        double sum = bitcoins + china;

        double euro = sum / 1.95;

        double commissionSum = commission * euro;
        double result = euro - commissionSum;

        System.out.printf("%.2f", result);






    }
}
