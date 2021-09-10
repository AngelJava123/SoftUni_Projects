package com.company;

import java.util.Scanner;

public class WeatherForecastPartTwo_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double degrees = Double.parseDouble(scanner.nextLine());
        String weatherType = "";

        if (degrees >= 26.00 && degrees <= 35.00) {
            weatherType = "Hot";
        } else if (degrees >= 20.1 && degrees <= 25.9) {
            weatherType = "Warm";
        } else if (degrees >= 15.00 && degrees <= 20.00) {
            weatherType = "Mild";
        } else if (degrees >= 12.00 && degrees <= 14.9) {
            weatherType = "Cool";
        } else if (degrees >= 5.00 && degrees <=11.9) {
            weatherType = "Cold";
        } else {
            weatherType = "unknown";
        }
        System.out.println(weatherType);
    }
}
