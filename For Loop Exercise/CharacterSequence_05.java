package com.company;

import java.util.Scanner;

public class CharacterSequence_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int position = 0; position <= input.length() - 1; position++) {
            System.out.println(input.charAt(position));

        }
    }
}
