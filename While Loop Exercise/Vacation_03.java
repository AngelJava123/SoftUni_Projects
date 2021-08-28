package com.company;

import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vacationCost = Double.parseDouble(scanner.nextLine());
        double availableCash = Double.parseDouble(scanner.nextLine());

        int days = 0;
        int daysSpend = 0;

        while (availableCash < vacationCost && daysSpend < 5) {
            String action = scanner.nextLine();
            double cash = Double.parseDouble(scanner.nextLine());
            days++;
            if (action.equals("spend")) {
                availableCash -= cash;
                daysSpend++;
                if (availableCash < 0) {
                    availableCash = 0;
                }
            } else if (action.equals("save")) {
                availableCash += cash;
                daysSpend = 0;
            }
        }
        if (availableCash >= vacationCost) {
            System.out.printf("You saved the money for %d days.", days);
        }
        if (daysSpend == 5) {
            System.out.println("You can't save the money.");
            System.out.printf("%d", days);
        }
    }
}
