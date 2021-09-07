package com.company;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        char[] splitText = text.toCharArray();

        for (int i = 0; i < splitText.length; i++) {
            char currentChar = splitText[i];
            splitText[i] = (char) (currentChar + 3);
        }
        System.out.println(splitText);
    }
}
