package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int[] command = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int s = command[1];
        int x = command[2];

        int[] numbs = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.stream(numbs).forEach(numbers::offer);

        for (int i = 0; i < s; i++) {
            numbers.poll();
        }
        if (numbers.contains(x)) {
            System.out.println(true);
        } else {
            if (!numbers.isEmpty()) {
                System.out.println(Collections.min(numbers));
            } else {
                System.out.println(0);
            }
        }
    }
}
