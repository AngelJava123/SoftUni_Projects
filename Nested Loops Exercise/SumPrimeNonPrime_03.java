package com.company;

import java.util.Scanner;

public class SumPrimeNonPrime_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sumPrime = 0;
        int sumNotPrime = 0;

        while (!input.equals("stop")) {
            int num = Integer.parseInt(input);
            boolean isPrime = true;

            if (num < 0) {
                System.out.println("Number is negative.");
            } else {
                for (int i = 2; i < num; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    sumPrime += num;
                } else {
                    sumNotPrime += num;
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Sum of all prime numbers is: " + sumPrime);
        System.out.println("Sum of all non prime numbers is: " + sumNotPrime);
    }
}
