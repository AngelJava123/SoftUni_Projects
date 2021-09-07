package com.company;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] forbiddenWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String forbiddenWord:forbiddenWords) {
            text = text.replace(forbiddenWord, "*".repeat(forbiddenWord.length()));
        }
        System.out.println(text);
    }
}
