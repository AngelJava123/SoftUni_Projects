package com.company;

import java.util.Locale;
import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine().toLowerCase(Locale.ROOT);
        returnVowelsOfString(word);

    }
    // a, e, i, o, u, y.
    private static void returnVowelsOfString(String word) {

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char currentWord = word.charAt(i);


            switch (currentWord) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
            }
        }
        System.out.println(count);
    }
}
