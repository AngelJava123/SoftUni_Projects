package com.company;

import java.util.Scanner;

public class GodzillaVsKong_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Декорът за филма е на стойност 10% от бюджета.
        //•	При повече от 150 статиста,  има отстъпка за облеклото на стойност 10%.

        //Ред 1.	Бюджет за филма – реално число в интервала [1.00 … 1000000.00]

        double filmBudget = Double.parseDouble(scanner.nextLine());

        //Ред 2.	Брой на статистите – цяло число в интервала [1 … 500]

        int statistNumber = Integer.parseInt(scanner.nextLine());

        //Ред 3.	Цена за облекло на един статист – реално число в интервала [1.00 … 1000.00]

        double clothesPrice = Double.parseDouble(scanner.nextLine());

        double decor = filmBudget * 0.1;

        double priceOnClothes = statistNumber * clothesPrice;

        if (statistNumber >= 150) {
            priceOnClothes = priceOnClothes -(priceOnClothes * 0.1);
        }

        double totalFilmPrice = decor + priceOnClothes;

        if (totalFilmPrice > filmBudget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", totalFilmPrice - filmBudget);
        } else { // filmBudget <= totalFilmPrice
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", filmBudget - totalFilmPrice); }

    }
}
