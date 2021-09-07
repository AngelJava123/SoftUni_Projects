package com.company;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        double totalSum = 0;

        for (String word:words) {
            char firstLetter = word.charAt(0);
            char lastLetter = word.charAt(word.length()-1);
            StringBuilder digit = new StringBuilder();

            double resultedNumber = 0;

            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);

                if (currentChar >= 48 && currentChar <= 57) {
                    digit.append(currentChar);
                }
            }
            double number = Double.parseDouble(String.valueOf(digit));

            if (Character.isUpperCase(firstLetter)) {
                double divide = number/ (firstLetter - 64);
                resultedNumber += divide;
            } else if (Character.isLowerCase(firstLetter)) {
                double multiply = (firstLetter - 96) * number;
                resultedNumber += multiply;
            }
            if (Character.isUpperCase(lastLetter)) {
                double subs = resultedNumber - (lastLetter - 64);
                totalSum += subs;
            } else if (Character.isLowerCase(lastLetter)) {
                double add = resultedNumber + (lastLetter - 96);
                totalSum += add;
            }
        }
        System.out.printf("%.2f", totalSum);
    }
}
