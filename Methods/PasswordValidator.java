package com.company;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        boolean isItInRange = charactersInRange(password);
        if (!isItInRange) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        boolean lettersOrDigits = returnIfNoLettersOrDigits(password);
        if (!lettersOrDigits) {
            System.out.println("Password must consist only of letters and digits");
        }
        boolean ifThereAreTwoDigits = TwoDigitsMustContain(password);
        if (!ifThereAreTwoDigits) {
            System.out.println("Password must have at least 2 digits");
        }
        if (isItInRange && lettersOrDigits && ifThereAreTwoDigits) {
            System.out.println("Password is valid");
        }
    }

    private static boolean TwoDigitsMustContain(String password) {

        int counter = 0;

        for (char i = 0; i < password.length(); i++) {
            char current = password.charAt(i);

            if (current >= 48 && current <= 57) {
                counter++;
            }
        }
        if (counter >= 2) {
            return true;
        }
        return false;
    }

    private static boolean returnIfNoLettersOrDigits(String password) {

        for (char i = 0; i < password.length(); i++) {
            char current = password.charAt(i);

            if (!Character.isLetterOrDigit(current)) {
                return false;
            }
        }
        return true;
    }

    private static boolean charactersInRange(String password) {

        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            counter++;
        }
        return (counter >= 6 && counter <= 10);
    }
}
