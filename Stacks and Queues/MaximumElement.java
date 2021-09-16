package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            int[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();

            if (commands.length == 2) {
                int xElement = commands[1];
                numbers.push(xElement);
            } else if (commands[0] == 2) {
                numbers.pop();
            } else if (commands[0] == 3) {
                System.out.println(Collections.max(numbers));
            }
        }
    }
}
