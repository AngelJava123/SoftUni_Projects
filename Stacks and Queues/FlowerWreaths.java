package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstLine = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[] secondLine = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();

        for (int i = 0; i < firstLine.length; i++) {
            lilies.push(firstLine[i]);
        }
        for (int i = 0; i < secondLine.length; i++) {
            roses.offer(secondLine[i]);
        }
        int wreaths = 0;
        int storedFlowers = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lilyNumber = lilies.pop();
            int roseNumber = roses.poll();

            int sum = lilyNumber + roseNumber;

            if (sum < 15) {
                storedFlowers += sum;
            } else if (sum > 15) {
                while (sum > 15) {
                    sum -= 2;
                }
                if (sum == 15) {
                    wreaths ++;
                } else {
                    storedFlowers += sum;
                }
            } else {
                wreaths++;
            }
        }
        if (storedFlowers >= 15) {
            int value = storedFlowers / 15;
            wreaths += value;
        }
        if (wreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreaths + " wreaths!");
        } else {
            int value = 5 - wreaths;
            System.out.println("You didn't make it, you need " + value + " wreaths more!");
        }
    }
}
