package com.company;

import java.util.Scanner;

public class SumNumbers_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int number = 1; number <= n ; number++) {
            int value = Integer.parseInt(scanner.nextLine());
            sum = sum + value;
        }
        System.out.println(sum);
    }
}
