package com.company;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String keyWord = scanner.nextLine();

        switch (type) {
            case "int":
                printOutput(keyWord);
                break;
            case "real":
                printOutput2(keyWord);
                break;
            case "string":
                printOutput3(keyWord);
                break;
        }
    }

    private static void printOutput3(String word) {

        System.out.println("$" + word + "$");
    }

    private static void printOutput2(String number) {


        double convertedString = Double.parseDouble(number);
        convertedString = convertedString * 1.5;
        System.out.printf("%.2f", convertedString);
    }

    private static void printOutput(String number) {

        int convertedString =Integer.parseInt(number);
       convertedString = convertedString * 2;
        System.out.println(convertedString);
    }
}
