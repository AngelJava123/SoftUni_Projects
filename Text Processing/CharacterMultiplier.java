package com.company;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        String word1 = words[0];
        String word2 = words[1];

        int totalSum = 0;

        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();

        if (word1Chars.length == word2Chars.length) {
            for (int i = 0; i < word1Chars.length; i++) {
                int wordMultiplied = word1Chars[i] * word2Chars[i];
                totalSum += wordMultiplied;
            }
        } else if (word2Chars.length > word1Chars.length) {
            for (int i = 0; i < word1Chars.length; i++) {
                int wordMultiplied = word1Chars[i] * word2Chars[i];
                totalSum += wordMultiplied;
            }
            for (int i = word1Chars.length; i < word2Chars.length; i++) {
                totalSum += word2Chars[i];
            }
        } else {
            for (int i = 0; i < word2Chars.length; i++) {
                int wordMultiplied = word1Chars[i] * word2Chars[i];
                totalSum += wordMultiplied;
            }
            for (int i = word2Chars.length; i < word1Chars.length; i++) {
                totalSum += word1Chars[i];
            }
        }
        System.out.println(totalSum);
    }
}
