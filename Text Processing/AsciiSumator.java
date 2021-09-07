package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char startSymbol = scanner.nextLine().charAt(0);
        char endSymbol = scanner.nextLine().charAt(0);
        String word = scanner.nextLine();
        List<Character> wordsBetweenSymbols = new ArrayList<>();

        char[] convertedWord = word.toCharArray();

        int totalSum = 0;

        for (int i = startSymbol; i < endSymbol ; i++) {
            wordsBetweenSymbols.add((char) i);
        }
        for (Character symbol:convertedWord) {
            for (Character symbol2:wordsBetweenSymbols) {
                if (symbol == symbol2) {
                    totalSum += symbol;
                }
            }
        }
        System.out.println(totalSum);
    }
}
