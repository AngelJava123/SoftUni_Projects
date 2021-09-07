package com.company;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(", ");
        StringBuilder validWord = new StringBuilder();

        for (String word:words) {
            for (int i = 0; i < word.length(); i++) {
                char currentSymbol = word.charAt(i);
                if (word.length() >= 3 && word.length() <= 16) {
                        if (Character.isAlphabetic(currentSymbol) || Character.isDigit(currentSymbol)
                                || currentSymbol == '-' || currentSymbol == '_' ) {
                            validWord.append(currentSymbol);
                    }
                    if (word.length() == validWord.length()) {
                        System.out.println(word);
                        validWord.setLength(0);
                    }
                }
            }
            validWord.setLength(0);
        }
    }
}
