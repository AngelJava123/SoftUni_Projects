package com.company;

import java.util.Scanner;

public class Dishwasher_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int remainingDetergent = 750 * Integer.parseInt(scanner.nextLine());
        int dishesCount = 0;
        int potsCount = 0;
        int counter = 0;

        while (remainingDetergent >= 0) {
            String text = scanner.nextLine();
            if (text.equals("End")) {
                break;
            }

            int items = Integer.parseInt(text);
            counter++;

            if (counter % 3 == 0) {
                int neededDetergent = items * 15;
                remainingDetergent = remainingDetergent - neededDetergent;

                if (remainingDetergent >= 0) {
                    potsCount += items;
                }
            } else {
                int neededDetergent = items * 5;
                remainingDetergent = remainingDetergent - neededDetergent;

                if (remainingDetergent >= 0) {
                    dishesCount += items;
                }
            }
        }
        if (remainingDetergent >= 0) {
            System.out.printf("Detergent was enough!" + "%d dishes and %d pots were washed." + "Leftover detergent %d ml.", dishesCount, potsCount, remainingDetergent);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", -remainingDetergent);
        }
    }
}
