package com.company;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int multiple = getMultipleOfEvensAndOdds(Math.abs(n));
        System.out.println(multiple);
    }

    private static int getMultipleOfEvensAndOdds(int n) {
        int evenSum = getSumOfEvenDigits(n);
        int oddSum = getSumOfOddDigits(n);

        return evenSum * oddSum;
    }

    private static int getSumOfEvenDigits(int n) {
        int evenSum = 0;

        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
            n /= 10;
        }
        return evenSum;
    }

    private static int getSumOfOddDigits(int n) {
        int oddSum = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 1) {
                oddSum += digit;
            }
            n /= 10;
        }
        return oddSum;
    }
}
