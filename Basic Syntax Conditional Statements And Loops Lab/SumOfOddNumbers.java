package com.company;

import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double sum = 0;

        for (int i = 1; i <= n ; i++) {
            int oddNumber = 2 * i - 1;
            System.out.println(oddNumber);
            sum+= oddNumber;

        }
        System.out.printf("Sum: %.0f", sum);
    }
}
