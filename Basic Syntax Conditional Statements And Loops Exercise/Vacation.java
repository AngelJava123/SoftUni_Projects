package com.company;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfPeople = scanner.nextLine();
        String dayType = scanner.nextLine();

        double totalPrice = 0;

        if (typeOfPeople.equals("Students")) {
            if (dayType.equals("Friday")) {
                totalPrice = 8.45 * numberOfPeople;
            } else if (dayType.equals("Saturday")) {
                totalPrice = 9.80 * numberOfPeople;
            } else if (dayType.equals("Sunday")) {
                totalPrice = 10.46 * numberOfPeople;
            }
        } else if (typeOfPeople.equals("Business")) {
            if (dayType.equals("Friday")) {
                totalPrice = 10.90 * numberOfPeople;
            } else if (dayType.equals("Saturday")) {
                totalPrice = 15.60 * numberOfPeople;
            } else if (dayType.equals("Sunday")) {
                totalPrice = 16 * numberOfPeople;
            }
        } else if (typeOfPeople.equals("Regular")) {
            if (dayType.equals("Friday")) {
                totalPrice = 15 * numberOfPeople;
            } else if (dayType.equals("Saturday")) {
                totalPrice = 20 * numberOfPeople;
            } else if (dayType.equals("Sunday")) {
                totalPrice = 22.50 * numberOfPeople;
            }
        }
        if ((typeOfPeople.equals("Students")) && (numberOfPeople >= 30)) {
            totalPrice = totalPrice - (totalPrice * 0.15);
        } else if ((typeOfPeople.equals("Business")) && (numberOfPeople >= 100)) {
            if (dayType.equals("Friday")) {
                totalPrice = totalPrice - (10 * 10.90);
            } else if (dayType.equals("Saturday")) {
                totalPrice = totalPrice - (10 * 15.60);
            } else if (dayType.equals("Sunday")) {
                totalPrice = totalPrice - (10 * 16);
            }
        } else if ((typeOfPeople.equals("Regular")) && (numberOfPeople >= 10 && numberOfPeople <= 20)) {
            totalPrice = totalPrice - (totalPrice * 0.05);
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
