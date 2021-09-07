package com.company;

import java.util.Scanner;

public class Substring2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordToRemove = scanner.nextLine();
        String input = scanner.nextLine();

        while(input.contains(wordToRemove)) {

            int beginIndex = input.indexOf(wordToRemove);
            int endIndex = beginIndex + wordToRemove.length();

            String firstPart = input.substring(0,beginIndex);
            String secondPart = input.substring(endIndex);

            input = firstPart + secondPart;
        }
        System.out.println(input);
    }
}
