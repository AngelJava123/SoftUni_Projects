package com.company;

import java.util.Scanner;

public class EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int value = n % 10;

        if (value == 0) {
            System.out.println("zero");
        } else if (value == 1) {
            System.out.println("one");
        } else if (value == 2) {
            System.out.println("two");
        } else if (value == 3) {
            System.out.println("three");
        } else if (value == 4) {
            System.out.println("four");
        } else if (value == 5) {
            System.out.println("five");
        } else if (value == 6) {
            System.out.println("six");
        } else if (value == 7) {
            System.out.println("seven");
        } else if (value == 8) {
            System.out.println("eight");
        } else if (value == 9) {
            System.out.println("nine");
        }
    }
}
