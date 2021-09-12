package com.company;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char character1 = scanner.nextLine().charAt(0);
        char character2 = scanner.nextLine().charAt(0);
        charactersInRangePrint(character1, character2);
    }
    private static void charactersInRangePrint(char character1,char character2 ) {

        if(character1 < character2) {
            for (char i = (char) (character1 + 1); i < character2; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (char i = (char) (character2 + 1); i < character1 ; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
