package com.company;

import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double capacity = Double.parseDouble(scanner.nextLine());
        String input = "";
        double totalVolume = 0;
        int counter = 0;


        while (true) {
            input = scanner.next();

            if (input.equals("End")) {
                System.out.println("Congratulations! All suitcases are loaded!");
                break;
            }

            totalVolume = Double.parseDouble(input);

            if (counter % 2 == 0 && counter != 0) {
                totalVolume = totalVolume + (totalVolume * 0.1);
            }

            if (capacity < totalVolume) {
                System.out.println("No more space!");
                break;
            }
            capacity -= totalVolume;
            counter++;

        }
        System.out.printf("Statistic: %d suitcases loaded.\n", counter);
    }
}

