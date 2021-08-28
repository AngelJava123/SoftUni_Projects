package com.company;

import java.util.Scanner;

public class FitnessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Integer.parseInt(scanner.nextLine());
        String gender = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();

        double price = 0;

        if (sport.equals("Gym")) {
            if (gender.equals("m")) {
                price = 42;
            } else if (gender.equals("f")) {
                price = 35;
            }
        } else if (sport.equals("Boxing")) {
            if (gender.equals("m")) {
                price = 41;
            } else if (gender.equals("f")) {
                price = 37;
            }
        } else if (sport.equals("Yoga")) {
            if (gender.equals("m")) {
                price = 45;
            } else if (gender.equals("f")) {
                price = 42;
            }
        } else if (sport.equals("Zumba")) {
            if (gender.equals("m")) {
                price = 34;
            } else if (gender.equals("f")) {
                price = 31;
            }
        } else if (sport.equals("Dances")) {
            if (gender.equals("m")) {
                price = 51;
            } else if (gender.equals("f")) {
                price = 53;
            }
        } else if (sport.equals("Pilates")) {
            if (gender.equals("m")) {
                price = 39;
            } else if (gender.equals("f")) {
                price = 37;
            }
        }
        if (age <= 19) {
            price = price - (price * 0.2);
        }
        if (money >= price) {
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        } else {
            System.out.printf("You don't have enough money! You need $%.2f more.", price - money);
        }
    }
}
