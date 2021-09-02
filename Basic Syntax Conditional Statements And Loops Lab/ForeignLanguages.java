package com.company;

import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String countryName = scanner.nextLine();

        switch (countryName) {
            case "USA":
            case "England":
                System.out.println("English");
                break;
            case "Spain":
            case "Mexico":
            case "Argentina":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}

