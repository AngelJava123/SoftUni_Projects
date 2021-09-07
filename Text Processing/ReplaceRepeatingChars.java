package com.company;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder newText = new StringBuilder();

        char firstLetter = text.charAt(0);
        newText.append(firstLetter);

        for (int i = 1; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar != newText.charAt(newText.length()-1)) {
                newText.append(currentChar);
            }
        }
        System.out.println(newText);
    }
}
