package com.company;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        double line1 = getDistanceBetweenTwoPoints(x1,y1,x2,y2);
        double line2 = getDistanceBetweenTwoPoints(x3,y3,x4,y4);

        boolean line1Point1IsCloserToZero = aPointCloserToTheZero(x1,y1,x2,y2);
        boolean line2Point1IsCloserToZero = aPointCloserToTheZero(x3,y3,x4,y4);

        if (line1 >= line2) {
            if (line1Point1IsCloserToZero) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x1,y1,x2,y2);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x2,y2,x1,y1);
            }
        } else {
            if (line2Point1IsCloserToZero) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x3,y3,x4,y4);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x4,y4,x3,y3);
            }
        }
    }

    private static boolean aPointCloserToTheZero(double x1, double y1, double x2, double y2) {

        double c1 = getHypotenuse(x1,y1);
        double c2 = getHypotenuse(x2,y2);

        boolean result = true;

        if (c2 < c1) {
            result = false;
        }
        return result;
    }

    private static double getHypotenuse(double a, double b) {

        a = Math.abs(a);
        b = Math.abs(b);

        double c = Math.sqrt((a * a) + (b * b));

        return c;
    }

    private static double getDistanceBetweenTwoPoints(double x1, double y1, double x2, double y2) {

        double sideA = Math.abs(x2 - x1);
        double sideB = Math.abs(y2 - y1);

        return Math.sqrt((sideA * sideB) + (sideB * sideB));
    }
}
