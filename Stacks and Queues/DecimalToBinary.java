package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        ArrayDeque<Integer> decimal = new ArrayDeque<>();

        int number = Integer.parseInt(scanner.nextLine());

        if (number == 0) {
            System.out.println(0);
            return;
        }

        while (number > 0) {
            int value = number % 2;
            decimal.push(value);
            number /= 2;
        }
        for (Integer integer : decimal) {
            System.out.print(integer);
        }
    }
}
