package com.company;

import java.util.Scanner;

public class Firm_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hoursNeeded = Integer.parseInt(scanner.nextLine()); // необходимите часовете
        int daysFirmHas = Integer.parseInt(scanner.nextLine()); // дните, с които фирмата разполага
        int workersWorkingExtraHours = Integer.parseInt(scanner.nextLine()); // броят на служителите, работещи извънредно

        double daysForWork = daysFirmHas * 0.9;
        double workHours = workersWorkingExtraHours * 2 * daysForWork ;
        double hoursDif = Math.floor((daysForWork * 8 * workersWorkingExtraHours) + workHours);

        if (hoursDif >= hoursNeeded) {
            System.out.printf("Yes!%.0f hours left.%n", hoursDif - hoursNeeded);
        } else {
            System.out.printf("Not enough time!%.0f hours needed.%n", hoursNeeded - hoursDif);
        }
    }
}
