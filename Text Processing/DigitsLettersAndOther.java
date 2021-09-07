package com.company;

import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder symbols = new StringBuilder();


        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isDigit(currentChar)) {
                digits.append(currentChar);
            } else if (Character.isAlphabetic(currentChar)) {
                letters.append(currentChar);
            } else {
                symbols.append(currentChar);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(symbols);
    }
}
