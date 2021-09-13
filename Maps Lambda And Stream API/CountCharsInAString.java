package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> occurrence = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar == ' ') {
                continue;
            }
            if (!occurrence.containsKey(currentChar)) {
                occurrence.put(currentChar, 1);
            } else {
                occurrence.put(currentChar, occurrence.get(currentChar) + 1);
            }
        }
        occurrence.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
