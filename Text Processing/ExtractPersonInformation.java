package com.company;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] words = scanner.nextLine().split(" ");

            StringBuilder name = new StringBuilder();
            StringBuilder age = new StringBuilder();

            for (String word:words) {
                char nameStartSymbol = (char) word.indexOf('@');
                char nameEndSymbol = (char) word.indexOf('|');
                char ageStartSymbol = (char) word.indexOf('#');
                char ageEndSymbol = (char) word.indexOf('*');

                    for (int j = nameStartSymbol; j < nameEndSymbol; j++) {
                        char currentSymbol = word.charAt(j);
                            name.append(currentSymbol);
                    }
                    for (int j = ageStartSymbol; j < ageEndSymbol; j++) {
                        char currentSymbol = word.charAt(j);
                            age.append(currentSymbol);
                    }
                if (name.length() != 0 && age.length() != 0) {
                    name.replace(0, 1, "");
                    age.replace(0,1,"");
                    System.out.printf("%s is %s years old.%n",name, age);
                    name.setLength(0);
                    age.setLength(0);
                }
            }
        }
    }
}
