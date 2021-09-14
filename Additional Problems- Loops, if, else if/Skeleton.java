package com.company;

import java.util.Scanner;

public class Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int controlMinutes = Integer.parseInt(scanner.nextLine());
        int controlSeconds = Integer.parseInt(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        int secondsFor100Meters = Integer.parseInt(scanner.nextLine());

        double additionalTime = (length / 120) * 2.5;
        double slopeTime = (length / 100) * secondsFor100Meters;
        double totalTime = slopeTime - additionalTime;

        int controlTimeSeconds = controlMinutes * 60 + controlSeconds;

        if (totalTime <= controlTimeSeconds) {
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.", totalTime);
        } else {
            double needSeconds = totalTime - controlTimeSeconds;
            System.out.printf("No, Marin failed! He was %.3f second slower.", needSeconds);
        }
    }
}
