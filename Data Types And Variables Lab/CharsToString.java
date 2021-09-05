package com.company;

import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();
        String lina2 = scanner.nextLine();
        String  line3 = scanner.nextLine();

        System.out.printf("%s%s%s", line1, lina2, line3);
    }
}
