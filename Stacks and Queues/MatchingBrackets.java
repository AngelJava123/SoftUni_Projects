package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> values = new ArrayDeque<>();

        String numbers = scanner.nextLine();

        for (int i = 0; i < numbers.length(); i++) {
            char currentChar = numbers.charAt(i);

            if (currentChar == '(') {
                values.push(i);
            } else if (currentChar == ')') {
                int currentIndex = i + 1;
                int top = values.pop();

                String sub = numbers.substring(top, currentIndex);

                System.out.println(sub);
            }
        }
    }
}
