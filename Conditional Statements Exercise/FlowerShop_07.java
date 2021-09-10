package com.company;

import java.util.Scanner;

public class FlowerShop_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magnolias = Integer.parseInt(scanner.nextLine()); // Брой магнолии
        int hyacinths = Integer.parseInt(scanner.nextLine()); // Брой зюмбюли
        int roses = Integer.parseInt(scanner.nextLine()); // Брой рози
        int cactus = Integer.parseInt(scanner.nextLine()); // Брой кактуси
        double giftPrice = Double.parseDouble(scanner.nextLine());

        double totalSum = magnolias * 3.25 + hyacinths * 4 + roses * 3.50 + cactus * 8;
        double profit = totalSum - (totalSum * 0.05);

        if (profit >= giftPrice) {
            System.out.printf("She is left with %.0f leva.", Math.floor(profit - giftPrice));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(giftPrice - profit));
        }
    }
}
