package com.company;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printAllNumbers(n);
    }

    private static void printAllNumbers(int n) {

        for (int i = 1; i <= n; i++) {

            int sum = 0;
            boolean oddDigit = false;
            int cpy = i;

            while (true) {
                if (cpy == 0) break;
                int right = cpy % 10;
                sum += right;
                if (!(right % 2 == 0)) oddDigit = true;
                cpy /= 10;
            }
            if(sum % 8 == 0 && oddDigit) {
                System.out.println(i);
            }
        }
    }
}
