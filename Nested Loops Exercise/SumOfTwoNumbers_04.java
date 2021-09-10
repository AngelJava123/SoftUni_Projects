package com.company;

import java.util.Scanner;

public class SumOfTwoNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int count = 0;
        boolean isFound = false;

        for (int number1 = startNumber; number1 <= endNumber ; number1++) {
            for (int number2 = startNumber; number2 <= endNumber; number2++) {
                count++;
                if (number1 + number2 == magicNumber) {
                    isFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, number1, number2, magicNumber);
                    break;
                }
            }
            if (isFound) {
                break;
            }
            }
        if (!isFound) {
            System.out.printf("%d combinations - neither equals %d", count, magicNumber);
        }
    }
}
