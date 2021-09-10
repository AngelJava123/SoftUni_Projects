package com.company;

import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());
        int kilometers = Integer.parseInt(scanner.nextLine());

        long conversion = number;
        short con = (short) kilometers;

        System.out.printf("Town %s has population of %d and area %d square km.", city, conversion, con);
    }
}
