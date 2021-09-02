package com.company;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String coins = scanner.nextLine();
        double sumMoneyInserted = 0;
        while (!coins.equals("Start")) {
           double coinsM = Double.parseDouble(coins);

           sumMoneyInserted += coinsM;

           if (coinsM != 0.1 && coinsM != 0.2 && coinsM != 0.5 && coinsM != 1 && coinsM != 2) {
               System.out.printf("Cannot accept %.2f%n", coinsM);
               sumMoneyInserted -= coinsM;
           }
           coins = scanner.nextLine();
        }
        String good = scanner.nextLine();
        double price = 0;
        boolean isGood = false;
        while (!"End".equals(good)) {
            switch (good) {
                case "Nuts":
                    price = 2.0;
                    isGood = true;
                    break;
                case "Water":
                    price = 0.7;
                    isGood = true;
                    break;
                case "Crisps":
                    price = 1.5;
                    isGood = true;
                    break;
                case "Soda":
                    price = 0.8;
                    isGood = true;
                    break;
                case "Coke":
                    price = 1.0;
                    isGood = true;
                    break;
            }
            if (sumMoneyInserted < price) {
                System.out.println("Sorry, not enough money");
            } else if (isGood) {
                System.out.println(String.format("Purchased %s", good));
                sumMoneyInserted -= price;
            } else {
                System.out.println("Invalid product");
            }
            good = scanner.nextLine();
        }
        System.out.println(String.format("Change: %.2f", sumMoneyInserted));
    }
}
