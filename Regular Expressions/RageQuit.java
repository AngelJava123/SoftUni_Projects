package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toUpperCase();

        StringBuilder repeatedSymbols = new StringBuilder();

        String stringSymbolsRegex = "(?<string>[\\D]*)(?<count>\\d+)";
        Pattern pattern = Pattern.compile(stringSymbolsRegex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String symbolsS = matcher.group("string");
            int number = Integer.parseInt(matcher.group("count"));

            for (int i = 0; i < number; i++) {
                repeatedSymbols.append(symbolsS);
            }
        }
        System.out.printf("Unique symbols used: %d%n", repeatedSymbols.chars().distinct().count());
        System.out.println(repeatedSymbols);
    }
}
