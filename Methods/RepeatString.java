package com.company;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int repeatCount = Integer.parseInt(scanner.nextLine());
        String result = repeatString(word,repeatCount);
        System.out.println(result);
    }

    private static String repeatString(String word, int repeatCount) {
        String result = "";

        for (int i = 0; i < repeatCount; i++) {
            result += (String.valueOf(word));
        }
        return result;
    }
}
