package com.company;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while(!command.equals("end")) {

            StringBuilder result = new StringBuilder();

            for (int i = command.length() - 1; i >= 0 ; i--) {
                char currentChar = command.charAt(i);
                result.append(currentChar);
            }
            System.out.println(command + " = " + result);

            command = scanner.nextLine();
        }
    }
}

