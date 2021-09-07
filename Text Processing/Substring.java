package com.company;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordToRemove = scanner.nextLine();

        String input = scanner.nextLine();

        int startIndex = input.indexOf(wordToRemove);

        while (startIndex != -1) {
            input = input.replace(wordToRemove, "");
            startIndex = input.indexOf(wordToRemove);
        }
        System.out.println(input);

        // while (input.contains(wordToRemove) {
         //        input = input.replace(wordToRemove, "");
    }
}
