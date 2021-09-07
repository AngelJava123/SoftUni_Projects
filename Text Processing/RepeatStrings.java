package com.company;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        StringBuilder result = new StringBuilder();

        for (String word:words) {
            for (int i = 0; i < word.length(); i++) {
                result.append(word);
            }
            System.out.print(result);
            result.setLength(0);
        }
    }
}
