package com.company;

import java.util.Scanner;

public class Radians_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radians = Double.parseDouble(scanner.nextLine());

        double deg = radians * 180/Math.PI;

        System.out.printf("%.0f", deg);



    }
}
