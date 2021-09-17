package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Long> numbers = new ArrayDeque<>();

        numbers.offer(1L);
        numbers.offer(1L);

        for (int i = 0; i < n - 2; i++) {
            long first = numbers.poll();
            long second = numbers.peek();

            numbers.offer(first + second);
        }
        long firstExtracted = numbers.poll();
        long secondExtracted = numbers.peek();

        if (n == 1) {
            System.out.println(1);
        } else if (n == 0) {
            System.out.println(0);
        } else {
            System.out.println(firstExtracted + secondExtracted);
        }
    }
}

