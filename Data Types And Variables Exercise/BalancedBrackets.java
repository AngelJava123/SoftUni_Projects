package com.company;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        boolean opened = false;
        boolean closed = false;
        int counter = 0;

        for (int i = 1; i < n; i++) {
            String input = scanner.nextLine();

            if (input.equals("(")) {
                opened = true;
                counter++;
                if (counter > 1) {
                    System.out.println("UNBALANCED");
                    break;
                }
            } else if (input.equals(")")) {
                closed = true;
                if (opened) {
                    opened = false;
                    closed = false;
                    counter = 0;
                    System.out.println("BALANCED");
                } else {
                    System.out.println("UNBALANCED");
                }
            }
        }
    }
}
