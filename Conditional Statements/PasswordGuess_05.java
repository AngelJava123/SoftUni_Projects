package com.company;

import java.util.Scanner;

public class PasswordGuess_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pass = scanner.nextLine();

        if ("s3cr3t!P@ssw0rd".equals(pass)) {
            System.out.println("Welcome");
        } else
            System.out.println("Wrong password!");


    }
}
