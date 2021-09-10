package com.company;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int lines = Integer.parseInt(scanner.nextLine());

        String sumOfMessage = "";

        for (int i = 0; i < lines; i++) {

            char input = scanner.nextLine().charAt(0);

            int value = input + key;

            char message = (char) value;

            sumOfMessage += message;

        }
        System.out.println(sumOfMessage);
    }
}
