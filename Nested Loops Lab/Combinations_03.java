package com.company;

import java.util.Scanner;

public class Combinations_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int validCombinationsCount = 0;
        for (int number1 = 0; number1 <= n ; number1++) {
            for (int number2 = 0; number2 <= n ; number2++) {
                for (int number3 = 0; number3 <= n ; number3++) {
                    if (number1 + number2 + number3 == n) {
                        validCombinationsCount++;
                    }
                }
                }
            }
        System.out.println(validCombinationsCount);
        }
    }
