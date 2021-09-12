package com.company;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        int sumOfNumbers = sumOfNumbers123(number1, number2);
        int finalResult = sumAfterSubtractions(sumOfNumbers, number3);
        System.out.println(finalResult);
    }

    private static int sumAfterSubtractions(int sumOfNumbers, int number3) {

        return (sumOfNumbers - number3);
    }

    private static int sumOfNumbers123(int number1, int number2) {

        return (number1 + number2);
    }
}
