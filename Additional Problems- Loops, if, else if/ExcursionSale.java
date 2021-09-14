package com.company;

import java.util.Scanner;

public class ExcursionSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int seaTripAmount = Integer.parseInt(scanner.nextLine());
        int mountainTripAmount = Integer.parseInt(scanner.nextLine());
        double profit = 0;
        double priceSea = 680;
        double priceMountain = 499;


        while (true) {
            String destination = scanner.nextLine();

            if (destination.equals("Stop") || (seaTripAmount == 0 && mountainTripAmount == 0)) {
                break;
            }
            if ((destination.equals("sea")) && (seaTripAmount > 0)) {
                profit += priceSea;
                seaTripAmount--;
            } else if ((destination.equals("mountain")) && (mountainTripAmount >0)) {
                profit += priceMountain;
                mountainTripAmount--;
            }
        }
        if (seaTripAmount == 0 && mountainTripAmount == 0) {
            System.out.println("Good job! Everything is sold.");
        }
            System.out.printf("Profit: %.0f leva.", profit);
    }
}

