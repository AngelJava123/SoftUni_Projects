package com.company;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordSecs = Double.parseDouble(scanner.nextLine()); // 1.	Рекордът в секунди
        double metres = Double.parseDouble(scanner.nextLine()); // 2.	Разстоянието в метри
        double oneMeterInSecs = Double.parseDouble(scanner.nextLine()); // 3.	Времето в секунди, за което изкачва 1 м

        double climb = metres * oneMeterInSecs;
        double add = Math.floor(metres / 50) * 30;

        double totalTime = climb + add;

        if (recordSecs > totalTime) {
            System.out.printf("Yes! The new record is %.2f seconds.", totalTime);
        } else {
            System.out.printf("No! He was %.2f seconds slower.", totalTime - recordSecs);

        }
    }
}
