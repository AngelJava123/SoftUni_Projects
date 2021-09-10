package com.company;

import java.util.Scanner;

public class HousePainting_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine()); // височината на къщата
        double y = Double.parseDouble(scanner.nextLine()); // дължината на страничната стена
        double h = Double.parseDouble(scanner.nextLine()); // височината на триъгълната стена на прокрива

        double sideWall = x * y;
        double window = 1.5 * 1.5;
        double totalSides = 2 * sideWall - 2 * window;
        double backWall = x * x;
        double frontDoor = 1.2 * 2;
        double totalFrontAndBack = 2 * backWall - frontDoor;

        double totalSum = totalSides + totalFrontAndBack;
        double greenPaint = totalSum / 3.4;

        double twoRoofTriangles = 2 * (x * y);
        double twoTriangles = 2 * (x * h / 2);
        double totalRoofSum = twoRoofTriangles + twoTriangles;

        double redPaint = totalRoofSum / 4.3;

        System.out.printf("%.2f%n", greenPaint);
        System.out.printf("%.2f", redPaint);
    }
}
