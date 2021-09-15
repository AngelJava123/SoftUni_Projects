package com.company;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> names = new ArrayDeque<>(List.of(input));

        int n = Integer.parseInt(scanner.nextLine());

        int cycle = 1;
        while (names.size() != 1) {
            for (int i = 1; i < n; i++) {
                names.offer(names.poll());
            }
            if (checkForPrime(cycle)) {
                System.out.println("Prime " + names.peek());
            } else {
                System.out.println("Removed " + names.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + names.poll());
    }

    static boolean checkForPrime(int inputNumber) {
        boolean isItPrime = true;

        if (inputNumber <= 1) {
            isItPrime = false;
        } else {
            for (int i = 2; i <= inputNumber / 2; i++) {
                if ((inputNumber % i) == 0) {
                    isItPrime = false;
                    break;
                }
            }
        }
        return isItPrime;
    }
}

