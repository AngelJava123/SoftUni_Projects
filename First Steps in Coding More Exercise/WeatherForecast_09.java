package com.company;

import java.util.Scanner;

public class WeatherForecast_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String whether = scanner.nextLine();

        if (whether.equals("sunny")) {
            System.out.println("It's warm outside!");
        } else {
            System.out.println("It's cold outside!");
        }
    }
}
