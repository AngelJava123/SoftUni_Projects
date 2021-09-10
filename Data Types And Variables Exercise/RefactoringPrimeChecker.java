package com.company;

import java.util.Scanner;

public class RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.next());
        boolean isPrime = true;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < n; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.printf("%d -> true%n", i);
            } else {
                System.out.printf("%d -> false%n", i);
            }
        }
    }
}
