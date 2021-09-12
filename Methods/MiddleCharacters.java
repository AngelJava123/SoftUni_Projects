package com.company;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        printMiddleCharacter(word);
    }

    private static void printMiddleCharacter(String word) {

        if (word.length() % 2 != 0) {

            int indexMiddleCharacter = word.length() / 2;
            System.out.printf("%c",word.charAt(indexMiddleCharacter));
        } else {
            int indexFirstMiddleCharacter = word.length() / 2 - 1;
            int indexSecondMiddleCharacter = word.length() / 2;
            System.out.printf("%c%c", word.charAt(indexFirstMiddleCharacter),word.charAt(indexSecondMiddleCharacter));
        }
    }
}
