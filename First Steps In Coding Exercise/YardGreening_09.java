package com.company;

import java.util.Scanner;

public class YardGreening_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double metersGreening = Double.parseDouble(scanner.nextLine());

        double wholeYard = metersGreening * 7.61;
        double discount = 0.18 * wholeYard;
        double Final = wholeYard - discount;

        System.out.printf("The final price is: %.2f lv.\n", Final);
        System.out.printf("The discount is: %.2f lv.", discount);
    }
}
